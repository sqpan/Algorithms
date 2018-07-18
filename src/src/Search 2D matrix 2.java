public boolean searchMatrix(int[][] matrix, int target) {
	// check corner case and init
	if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {return false;}
	int col = matrix[0].length - 1, row = 0;
	// binary search loop
	while (row <= matrix.length - 1 && col >= 0) {
		if (target == matrix[row][col]) {return true;}
		else if (target < matrix[row][col]) {col—;}
		else {row++;}
	}
	return false;
}
