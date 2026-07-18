class Solution {
    
    List<List<Integer>> res;
    List<Integer> cur;
    boolean[] used;
    int[] nums;
    
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        res = new ArrayList<>();
        cur = new ArrayList<>();
        used = new boolean[nums.length];
        dfs(0);
        return res;
    }

    private void dfs(int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(cur));
        }
        for(int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            cur.add(nums[i]);
            used[i] = true;
            dfs(idx + 1);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }
}
