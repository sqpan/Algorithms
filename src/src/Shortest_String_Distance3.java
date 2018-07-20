
public class Shortest_String_Distance3 {

	public static void main(String[] args) {
		String[] words = {"a", "a", "b", "b"};
		System.out.println(shortestWordDistance(words, "a", "a"));

	}
	
	public static int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2 || word1 == null || word2 == null) {
            return -1;
        }   
        int result = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        if (word1.equals(word2)) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1) && index1 == -1) {
                    index1 = i;
                }         
                else if (words[i].equals(word1) && index1 != -1) {
                    index2 = i;
                    result = Math.min(result, index2 - index1);
                    index1 = index2;
                }
            }
        }
        else {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    index1 = i;
                }
                if (words[i].equals(word2)) {
                    index2 = i;
                }
                if (index1 != -1 && index2 != -1) {
                    result = Math.min(result, Math.abs(index1 - index2));
                }
            }
        }
        return result;
    }

}
