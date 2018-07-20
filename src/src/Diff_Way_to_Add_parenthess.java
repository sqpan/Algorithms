import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class Diff_Way_to_Add_parenthess {

	public static void main(String[] args) {
		String a = "2-1-1";
		System.out.println(diffWaysToCompute(a));

	}
	
	public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1res = diffWaysToCompute(part1);
                List<Integer> part2res = diffWaysToCompute(part2);
                for (int a : part1res) {
                    for (int b : part2res) {
                        int c = 0;
                        if (input.charAt(i) == '+') {
                            c = a + b;
                            break;
                        }
                        else if (input.charAt(i) == '-') {
                            c = a - b;
                            break;
                        }
                        else if (input.charAt(i) == '*') {
                            c = a * b;
                            break;
                        }
                        result.add(c);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}
