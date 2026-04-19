class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), out);
        return out;
    }

    void solve(int[] nums, int i, List<Integer> buff, List<List<Integer>> out) {
        // System.out.println("i: " + i + ", buff: " + buff + ", out: " + out);
        if (i == nums.length) { // buffer is output
            out.add(new ArrayList<>(buff));
            return;
        }
        solve(nums, i+1, buff, out);
        buff.add(nums[i]);
        solve(nums, i+1, buff, out);
        buff.remove(buff.size() - 1);
    }
}
