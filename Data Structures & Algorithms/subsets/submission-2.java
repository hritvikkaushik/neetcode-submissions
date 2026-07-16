class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        buildSubsets(nums, result, 0, currentSubset);
        return result;
    }

    private void buildSubsets(int[] nums, List<List<Integer>> result, int i, List<Integer> currentSubset) {
        if (i == nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        currentSubset.add(nums[i]);
        buildSubsets(nums, result, i + 1, currentSubset);

        currentSubset.remove(currentSubset.size() - 1);
        buildSubsets(nums, result, i + 1, currentSubset);
    }
}
