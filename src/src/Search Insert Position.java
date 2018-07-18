// Search Insert Position
public int searchInsert(int[] nums, int target) {
	// check corner case and init
	int n = nums.length;
	if (n < 0) {return -1;}
	int left = 0, right = n - 1, mid;
	// binary search
	while(left + 1 < right) {
		mid = left + (right - left) / 2;
		if ((nums[mid] > target && target > nums[mid - 1]) || nums[mid] == target) {
			return mid - 1;
		}
		else if (nums[mid] < target) {left = mid;}
		else {right = mid;}
	}
	// check last two position
	if (target <= nums[left]) {return left;}
	else if (target <= nums[right]) {return right;}
	else {return right + 1;}
}
