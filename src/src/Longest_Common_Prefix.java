
public class Longest_Common_Prefix {

	public static void main(String[] args) {
		String[] strs = {"ABCD","ABEF","ACEF"};
		System.out.print(longestCommonPrefix(strs));
	}
	
	public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int result = 0;
        for (int i = 1; i < strs.length; i++) {
            int prefix = 0;
            for (int j = 0; j < Math.min(strs[i].length(), strs[i - 1].length()); j++) {
                if (strs[i].charAt(j) != strs[i - 1].charAt(j)) {
                    break;
                }
                else {
                    prefix++;
                }
            }
            if (i == 1) {
            	result = prefix;
            }
            result = Math.min(result, prefix);
        }
        return strs[0].substring(0, result);
    }

}
