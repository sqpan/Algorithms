
public class Is_Sequence {

	public static void main(String[] args) {
		String a = "";
		String b = "abc";
		System.out.println(isSubsequence(a,b));
	}
	
	public static boolean isSubsequence(String s, String t) {
        if (t == null || t.length() == 0) {
            if (s == null || s.length() == 0) {
                return true;
            }
            return false;
        }    
        if (s.length() > t.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(count) == t.charAt(i)) {
                count++;
            }
            if (count == s.length()) {
                return true;
            }
        }
        return false;
    }

}
