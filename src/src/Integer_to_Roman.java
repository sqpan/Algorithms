
public class Integer_to_Roman {

	public static void main(String[] args) {
		System.out.println(intToRoman(1));

	}
	
	public static String intToRoman(int n) {
        if (n <= 0) {
            return "";
        }
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    String result = new String();
	    for (int i = 0; i < nums.length; i++) {
	        int count = n / nums[i];
	        n = n - count * nums[i];
	        for (int j = 1; j <= count; j++) {
	            result = result + symbols[i];
	        }
	    }
	    return result;
    }

}
