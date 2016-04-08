
public class CompareStrings {

	public static void main(String[] args){
		compare("ABCD", "AABC");	
	}
	
	public static boolean compare(String a, String b) {
		//initialize the count table
		int count[] = new int[26];
		for (int i = 0; i < 26; i++) {
			count[i] = 0;
		}
		
		//count string a
		for (int j = 0; j < a.length(); j++) {
			count[a.charAt(j) - 'A'] += 1;
		}
		
		//minus string b on a's account
		//if have any negative values, return false. Or return true
		for (int k = 0; k < b.length(); k++) {
			count[b.charAt(k) - 'A'] -= 1;
			if (count[b.charAt(k) - 'A'] < 0) {
				return false;
			}
		}		
		for (int i = 0; i < 26; i++){
			System.out.print(count[i] + " ");
		}
		return true;
	}
	
}
