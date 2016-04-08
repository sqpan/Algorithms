
public class Length_of_last_word {
	public int lengthOfLastWord(String s) {
        // string to char array
        char[] new_s = s.toCharArray();
        int length = 0;
        
        // read the char array and count the length
        for (int i = new_s.length - 1; i >= 0; i--) {
        	if (length == 0) {
        		// if the last of word is a space, continue search
                if (new_s[i] == ' ') {
                    continue;
                }
                else {
                    length++;
                }
            }
            else {
                //facing a space here means the last word ends
            	if (new_s[i] == ' ') {
                    break;
                }
                else {
                    length++;
                }
            }
        }
        return length;
    }
}
