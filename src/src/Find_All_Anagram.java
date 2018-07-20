import java.util.List;
import java.util.ArrayList;

public class Find_All_Anagram {

	public static void main(String[] args) {
		String a = "cbaebabacd";
		String b = "abc";
		System.out.println(findAnagrams(a,b));
	}
	
// Method 1 Sliding Window
	
	public static List<Integer> findAnagrams(String s, String p) {
	    List<Integer> list = new ArrayList<>();
	    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
	    int[] hash = new int[26]; //character hash
	    //record each character in p to hash
	    for (char c : p.toCharArray()) {
	        hash[c - 'a']++;
	    }
	    //two points, initialize count to p's length
	    int left = 0, right = 0, count = p.length();
	    while (right < s.length()) {
	        //move right everytime, if the character exists in p's hash, decrease the count
	        //current hash value >= 1 means the character is existing in p
	        if (hash[s.charAt(right++) - 'a']-- >= 1) count--; 
	        
	        //when the count is down to 0, means we found the right anagram
	        //then add window's left to result list
	        if (count == 0) list.add(left);
	    
	        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
	        //++ to reset the hash because we kicked out the left
	        //only increase the count if the character is in p
	        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
	        if (right - left == p.length() && hash[s.charAt(left++) - 'a']++ >= 0) count++;
	    }
	    return list;
	}

// Method 2 Tradition 
	
/*	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null) {
            return result;
        }
        int[] letter = new int[26];
        for (int i = 0; i < p.length(); i++) {
            letter[p.charAt(i) - 'a']++;
        }
        int[] final copy = letter;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (letter[s.charAt(i) - 'a'] <= 0) {
                ;
                count = 0;
            }
            if (copy[s.charAt(i) - 'a'] > 0) {
                copy[s.charAt(i) - 'a']--;
                count++;
            }
            if (count == p.length()) {
                result.add(i + 1 - p.length());
                count = 0;
                copy = letter;
            }
        }
        return result;
    }
*/
}
