class Solution {

    int[] nums;
    List<List<Integer>> res;
    List<Integer> cur;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        cur = new ArrayList<>();
        this.nums = nums;
        Arrays.sort(this.nums);
        generateSubsets(0);
        return res;
    }

    private void generateSubsets(int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        // Choice 1: take the ith element
        cur.add(nums[i]);
        generateSubsets(i + 1);
        cur.remove(cur.size() - 1);

        // Choice 2: skip the ith element... we also need to skip duplicates here
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        generateSubsets(i + 1);   
    }
}

/*

*/