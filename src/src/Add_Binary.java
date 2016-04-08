import java.lang.String;

public class Add_Binary {
	public static void main(String[] args) {
		String c = addBinary("10", "1000");
		System.out.println(c);
	}
	
	public static String addBinary(String a, String b){
	        //corner case test
	        if (a.length() == 0 || b.length() == 0 || a == null || b == null) {
	            return null;
	        }
	        
	        //swift if a is smaller
	        if (a.length() < b.length()) {
	            String tmp;
	            tmp = a;
	            a = b;
	            b = tmp;
	        }
	        
	        //variable declear
	        int carry = 0;
	        int la = a.length() - 1;
	        int lb = b.length() - 1;
	        String result = "";
	        
	        //add till b's length
	        while (lb >= 0) {
	            int sum = 0;
	            sum = (int)(a.charAt(la) - '0') + (int)(b.charAt(lb) - '0') + carry;
	            result = String.valueOf(sum % 2) + result;
	            carry = sum / 2;
	            lb--;
	            la--;
	        }
	        
	        //add only a part
	        while (la >= 0) {
	            int sum = 0;
	            sum = (int)(a.charAt(la) - '0') + carry;
	            carry = sum / 2;
	            result = String.valueOf(sum % 2) + result;
	            la--;
	        }
	        
	        //last digit of carry
	        if (carry > 0) {
	            result = 1 + result;
	        }
	        return result;
	    }
}
