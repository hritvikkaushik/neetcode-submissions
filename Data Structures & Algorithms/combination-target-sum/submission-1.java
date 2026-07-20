class Solution {

    int[] nums;
    List<List<Integer>> res;
    List<Integer> cur;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        cur = new ArrayList<>();
        this.nums = nums;
        findCombinations(target, 0);
        return res;
    }

    private void findCombinations(int target, int startingIndex) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0 || startingIndex == nums.length) {
            return;
        }
        for (int i = startingIndex; i < nums.length; i++) {
            cur.add(nums[i]);
            findCombinations(target - nums[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}
