import java.util.HashSet;

public class Max_Product_of_Word_Length {

	public static void main(String[] args) {
		String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
		System.out.println(maxProduct(words));
	}
	
	public static int maxProduct(String[] words) {
		if (words == null || words.length == 0) {
            return 0;
        }    
        int result = 0;
        int[] value = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                value[i] |= 1 >> (words[i].charAt(j) - 'a'); 
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((value[i] & value[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }

}
