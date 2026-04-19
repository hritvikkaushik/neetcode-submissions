class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        search(0, new ArrayList<>(), nums);
        return res;
    }

    void search(int i, List<Integer> subset, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        search(i+1, subset, nums);
        subset.remove(subset.size() - 1);

        while (i+1 < nums.length && nums[i] == nums[i+1]) i++;

        search(i+1, subset, nums);
    }
}
