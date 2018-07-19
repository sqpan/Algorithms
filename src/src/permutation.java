public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    backTrack(result, new ArrayList<Integer>(), nums);
    return result;
}
private void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums) {
    if (list.size() == nums.length) {
        // it is call by reference, need to create new one, or it will change after increased in result
        result.add(new ArrayList<Integer>(list));
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if (list.contains(nums[i])) continue;
        list.add(nums[i]);
        backTrack(result, list, nums);
        list.remove(list.size() - 1);
    }
}