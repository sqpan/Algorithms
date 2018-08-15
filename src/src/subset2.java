public List<List<Integer>> subsetsWithDup(int[] nums) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	if (nums == null || nums.length == 0) {return result;}
	Arrays.sort(nums);
	backtrack(result, new ArrayList<Integer>(), nums, 0);
	return result;
}

private void backtrack(List<List<Integer>> result, List<Integer> level, int[] nums, int start) {
	result.add(new ArrayList<Integer>(level));
	for (int i = start; i < nums.length; i++) {
		// if the new number is same as the previous one, and the previous is no used, continue
		if (i > start && nums[i] == nums[i - 1]) {continue;}
		level.add(nums[i]);
		backtrack(result, level, nums, i + 1);
		level.remove(level.size() - 1);
	}
}