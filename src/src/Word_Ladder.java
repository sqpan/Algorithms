import java.util.HashSet;
import java.util.Set;

public class Word_Ladder {

	public static void main(String[] args) {
		Set<String> wordList = new HashSet<String>();
		wordList.add("a");
		wordList.add("b");
		wordList.add("c");
		String begin = "a";
		String end = "c";
		System.out.println(ladderLength(begin, end , wordList));
	}
	
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            return 0;
        }    
        int count = 1;
        HashSet<String> beginSet = new HashSet<String>();
        HashSet<String> endSet = new HashSet<String>();
        HashSet<String> visited = new HashSet<String>();
        beginSet.add(beginWord);
        visited.add(beginWord);
        visited.add(endWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            count++;
            if (beginSet.size() > endSet.size()) {
                HashSet<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            HashSet<String> temp = new HashSet<String>();
            for (String s : beginSet) {
                char[] chars = s.toCharArray();
                for (int i = 0; i < s.length(); i++) {
                    char old = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String test = String.valueOf(chars);
                        if (endSet.contains(test)) {
                            return count;
                        }
                        if (!visited.contains(test) && wordList.contains(test)) {
                            visited.add(test);
                            temp.add(test);
                        }
                        chars[i] = old;
                    }
                }
            }
            beginSet = temp;
        }
        return 0;
    }
}
