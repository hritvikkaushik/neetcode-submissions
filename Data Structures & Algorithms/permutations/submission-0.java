class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        find(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    void find(List<Integer> input, int[] nums, boolean[] pick) {
        if (input.size() == nums.length) {
            res.add(new ArrayList<>(input));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                input.add(nums[i]);
                pick[i] = true;
                find(input, nums, pick);
                input.remove(input.size() - 1);
                pick[i] = false;
            }
        }
    }
}
