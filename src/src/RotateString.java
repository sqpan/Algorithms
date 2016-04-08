import java.util.*;
import java.lang.String;

public class RotateString {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        if (str.length == 0 || str == null) {
            return;
        }
        offset = offset % str.length;
        reverse(str, 0, str.length - 1);
        reverse(str, 0, offset - 1);
        reverse(str, offset, str.length -1);
    }
    
    public void reverse(char[] str, int start, int end) {
        while (start < end) {
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
    }
}