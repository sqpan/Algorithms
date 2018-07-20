
public class Repeated_Substring {

	public static void main(String[] args) {
		String test = "abcabcabcabc";
		System.out.println(repeatedSubstringPattern(test));
	}
	
	public static boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        if (str == null || str.length() == 0) {
            return true;
        }    
        for (int i = len / 2; i > 0; i--) {
            if (len % i == 0) {
                String sub = str.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < len / i; j++){
                    sb.append(sub);
                }
                String make = sb.toString();
                if (make.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

}
