public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    boolean[] used = new boolean[nums.length];
    backtrack(result, new ArrayList<Integer>(), used, nums);
    return result;
}

private void backtrack(List<List<Integer>> result, ArrayList<Integer> level, boolean[] used, int[] nums) {
    if (level.size() == nums.length) {
        // it is call by reference, need to create new one, or it will change after increased in result
        result.add(new ArrayList<>(level));
    }
    for (int i = 0; i < nums.length; i++) {
        if (used[i]) {continue;}
        // if the current number is same as previous one, check if previous number is used.
        // this will include same number sequence will incresing index number
        // if input: 2,2,2: only 2(1st),2(2ed),2(3rd) will be in the permutation
        if (i != 0 && nums[i - 1] == nums[i] && !used[i - 1]) {continue;}
        level.add(nums[i]);
        used[i] = true;
        backtrack(result,level,used,nums);
        used[i] = false;
        level.remove(level.size() - 1);
    }
}