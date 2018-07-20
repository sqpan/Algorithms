package Graph;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class word_ladder2 {

	public static void main(String[] args) {
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		String begin = "hit";
		String end = "cog";
		List<List<String>> result =findLadders(begin, end , wordList);
	}
	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> solution = new ArrayList<String>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        Map<String, List<String>> neighbor = new HashMap<String, List<String>>();
        bfs(beginWord, endWord, wordList, distance, neighbor);
        dfs(beginWord, endWord, wordList, distance, neighbor, result, solution);
        return result;
    }
    
    private static void bfs(String beginWord, String endWord, List<String> wordList, Map<String, Integer> distance, Map<String, List<String>> neighbor) {
        int dis = 1;
        distance.put(beginWord, dis);
        neighbor.put(beginWord, new ArrayList<String>());
        for (int i = 0; i < wordList.size(); i++) {
            neighbor.put(wordList.get(i), new ArrayList<String>());
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            dis++;
            boolean foundEnd = false;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    String next = wordList.get(j);
                    if (next.equals(endWord) && distance.containsKey(next)) {
                        neighbor.get(cur).add(next);
                        foundEnd = true;
                    }
                    if (diff(cur, next) && !distance.containsKey(next)) {
                        distance.put(next, dis);
                        neighbor.get(cur).add(next);
                        queue.offer(next);
                        if (next.equals(endWord)) {
                            foundEnd = true;
                        }
                    }
                    
                    
                }
                if (foundEnd) {break;}
            }
        }
    }
    
    private static boolean diff(String a, String b) {
        if (a.length() != b.length()) {return false;}
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 1) {return false;}
            }            
        }
        return count == 1;
    }
    
    private static void dfs(String beginWord, String endWord, List<String> wordList, Map<String, Integer> distance, Map<String, List<String>> neighbor, List<List<String>> result, List<String> solution) {
        solution.add(beginWord);
    		if (endWord.equals(beginWord)) {result.add(new ArrayList<String>(solution));}
        for (String cur : neighbor.get(beginWord)) {
            if (distance.get(cur) == distance.get(beginWord) + 1) {
                dfs(cur, endWord, wordList, distance, neighbor, result, solution);
            }
        }
        solution.remove(solution.size() - 1);
    }
}
