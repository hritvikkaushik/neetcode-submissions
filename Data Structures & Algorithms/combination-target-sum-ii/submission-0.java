class Solution {
    int[] nums;
    List<List<Integer>> res;
    List<Integer> current;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        current = new ArrayList<>();
        nums = candidates;
        Arrays.sort(nums);
        findCombinations(target, 0);
        return res;
    }

    private void findCombinations(int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
        }
        if (target < 0 || start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            findCombinations(target - nums[i], i + 1);
            current.remove(current.size() - 1);
        }
    }
}

/*
findCombinations(target, start) {
    if (target == 0) {
        res.add(new ArrayList<>(current));
    }
    if (target < 0) {
        return;
    }
    for (int i = start; i < nums.length; i++) {
        current.add(nums[i]);
        findCombinations(target - nums[i], start + 1);
        current.remove(current.size() - 1);
    }
}
*/