
public class Count_Say {
	public static String countSayCorrect(int n) {
		// use a string builder to save the say
        String oldString = "1";
        
        // travese the string to count and say
        while (n-- > 0) {
        	StringBuilder sb = new StringBuilder();
        	char[] charArray = oldString.toCharArray();     
        	System.out.println("n: " + n);
            for (int i = 0; i <= oldString.length() - 1; i++) {
                int count = 1;
                while (i < oldString.length() - 1 && charArray[i] == charArray[i + 1]) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + String.valueOf(charArray[i]));                
            }
            oldString = sb.toString();               
        }
        return oldString;
	}
}
