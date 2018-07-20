import java.util.HashMap;

public class Longest_Substring {

	public static void main(String[] args) {
		String a = "abba";
		//System.out.println(Arrays.binarySearch(arr, a));
		System.out.println(lengthOfLongestSubstring(a));
	}
	public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //j = map.get(s.charAt(i)) + 1;
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            result = Math.max(result, i - j + 1);
            map.put(s.charAt(i), i);
        }
        return result;
    }

}
