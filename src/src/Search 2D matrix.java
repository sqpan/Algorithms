// 74 Search 2D matrix
public boolean searchMatrix(int[][] matrix, int target) {
	// check corner case and init
	if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {return false;}
	int left = 0, right = matrix.length * matrix[0].length - 1, mid, col, row;
	// binary search loop
	while (left < right - 1) {
		mid = left + (right - left) / 2;
		row = mid / matrix[0].length;
		col = mid % matrix[0].length;
		if (matrix[row][col] == target) {return true;}
		else if (matrix[row][col] < target) {left = mid;}
		else {right = mid;}
	}
	// check last two case
	if (matrix[left / matrix[0].length][left % matrix[0].length] == target || 
	     matrix[right / matrix[0].length][right % matrix[0].length] == target) {return true;}
	else {return false;}
}
