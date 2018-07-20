import java.util.ArrayList;

public class nQueens {
	public static void Main(String[] args) {
    	int n = 1;
    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    	result = solveNQueens(n);
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			System.out.println(result.get(i).get(j));
    		}
    	}
    }
	
	private static ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (n <= 0) {
            return result;
        }
        nQueens(res, list, n - 1);
        result = beString(result, res, n - 1);
        return result;
    }
    
    private static void nQueens(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list,int n) {
        if (list.size() == n) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(list, list.size(), n) == false) {
                continue;
            }
            list.add(i);
            nQueens(res, list, n);
            list.remove(list.size() - 1);
        }
    }
    
    private static boolean isValid(ArrayList<Integer> list, int row, int column) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == column) {
                return false;
            }
            else if (list.get(i) == i && row == column) {
                return false;
            }
            else if (list.get(i) + i == row + column) {
                return false;
            }
        }
        return true;
    }
    
    private static ArrayList<ArrayList<String>> beString(ArrayList<ArrayList<String>> result, ArrayList<ArrayList<Integer>> res, int n) {
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (res.get(i).get(j) != 0) {
                    sb.append("Q");
                }
                else {
                    sb.append(".");
                }
            }
            result.get(i).add(sb.toString());
        }    
        return result;
    }
};
