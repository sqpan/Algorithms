
public class strstr {

	public static void main(String[] args) {
		String a = "mississippi";
		String b = "issip";
		System.out.println(strStr(a,b));
	}
	public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }        
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(count)) {
                count++;
                if (count == needle.length()) {
                    return i - count + 1;
                }
            }
            else {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    count = 1;
                }
                else {
                    count = 0;
                }
            }
        }
        return -1;
    }

}
