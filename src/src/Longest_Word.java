import java.util.ArrayList;

public class Longest_Word {
	ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> longest = new ArrayList<String>();
        for(String str : dictionary) {
            if(longest.isEmpty() || str.length() > longest.get(0).length()) {
                longest.clear();
                longest.add(str);
            }
            else if(str.length() == longest.get(0).length()) {
                longest.add(str);
            }
        }
        return longest;
    }
}
