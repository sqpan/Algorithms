public class Valid_Panlindrome {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // check the corner case
        if (s.length() == 0 || s == null) {
            return true;    // empty string
        }
        
        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            // check the real boundary without space or other char
            while (front < end && !isValid(s.charAt(front))) {
                front++;
            }
            if (front == end) {
                return true;    // this is a string with all spaces
            }
            while (end > front && !isValid(s.charAt(end))) {
                end--;  // check the real end without space
            }
            // formal check calid palindrome
            if (Character.toLowerCase(s.charAt(front)) == 
                Character.toLowerCase(s.charAt(end))) {
                    front++;
                    end--;
            }
            else {
                return false;
            }
        }
        return true;
    }
    // isValid function
    public boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}