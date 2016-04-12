public class Space_Replacement {

	public static void main(String[] args) {
		String hi = "hello world";
		char[] greeting = hi.toCharArray();
		replaceBlank(greeting, 11);
	}
	
	public static int replaceBlank(char[] string, int length) {
        // traverse the string to check how many spaces are there
        int num = 0;
        for (int i = 0; i < length -1; i++) {
            if (string[i] == ' ') {
                num++;
            }
        }
        // create a new string that replace all spaces to "%20"
        int newlength = length + num * 2;
        char[] newString = new char[newlength];
        int j = 0;
        for (int i = 0; i <= length - 1; i++) {
            if (string[i] != ' ') {
                newString[j] = string[i];
                j++;
            }
            else {
                newString[j] = '%';
                j++;
                newString[j] = '2';
                j++;
                newString[j] = '0';
                j++;
            }
        }
        System.out.println(newString);
        return newlength;
    }
}
