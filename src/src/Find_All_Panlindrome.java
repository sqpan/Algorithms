import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Find_All_Panlindrome {

	public static void main(String[] args) {
		//s: "cbaebabacd" p: "abc"
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println(findAnagrams(s,p));

	}
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		if (s == null) {
            return result;
        }
        int[] letter = new int[26];
        for (int i = 0; i < p.length(); i++) {
            letter[p.charAt(i) - 'a']++;
        }
        final int[] copy = new int[26];
        for (int i = 0; i < 26; i++) {
        	copy[i] = letter[i];
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (letter[s.charAt(i) - 'a'] <= 0) {
                letter = copy;
                count = 0;
            }
            if (letter[s.charAt(i) - 'a'] > 0) {
                letter[s.charAt(i) - 'a']--;
                count++;
            }
            if (count == p.length()) {
                result.add(i + 1 - p.length());
                count = 0;
                letter = copy;
            }
        }
        return result;
    }

}
