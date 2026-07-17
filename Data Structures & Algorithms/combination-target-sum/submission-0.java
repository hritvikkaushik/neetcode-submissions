class Solution {

    int[] nums;
    List<List<Integer>> res;
    List<Integer> cur;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        cur = new ArrayList<>();
        this.nums = nums;
        check(target, 0);
        return res;
    }

    private void check(int target, int idx) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0 || idx == nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            cur.add(nums[i]);
            check(target - nums[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}

/*
What is the choice?

target mein se har element minus kar ke naya target banega
ye recursively karo jab tak target 0 na ho jaye
agar target negative ho gaya toh you have gone too far, go back

How to frame this?
if target == 0, add cur
if target < 0, return
for(n: nums) {
    add n to cur
    check(currentSum + n, target - n);
    remove n from cur
}

*/