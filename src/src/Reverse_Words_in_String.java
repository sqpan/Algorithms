import java.lang.String;
import java.lang.StringBuilder;

public class Reverse_Words_in_String {
	
	public static String reverseWords(String s) {
		// check corner case: no input or input is null
        if (s.length() == 0 || s == null) {
            return "";
        }
        // split the original string and reverse it into a string builder
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            if(!array[i].equals("")) {
               sb.append(array[i]).append(" "); 
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0,sb.length() - 1);	
	}
}
