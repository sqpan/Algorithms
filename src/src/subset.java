public List<List<Integer>> subsets(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();        
    backTrack(result, list, nums, 0);
    return result;
}
private void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
    result.add(new ArrayList<Integer>(list));
    // start index keeps backtrack only go to the index with higher sequence
    for (int i = start; i < nums.length; i++) {
        list.add(nums[i]);
        // bug: pass i + 1 to next level, not start + 1;
        backTrack(result, list, nums, i + 1);
        list.remove(list.size() - 1);
    }
}