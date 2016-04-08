
public class Length_of_last_word {
	public int lengthOfLastWord(String s) {
        // string to char array
        char[] new_s = s.toCharArray();
        int length = 0;
        
        // read the char array and count the length
        for (int i = new_s.length - 1; i >= 0; i--) {
            if (length == 0) {
                if (new_s[i] == ' ') {
                    continue;
                }
                else {
                    length++;
                }
            }
            else {
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
