class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int res = 1;
        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int m = nums[i-1];
            if (n == m + 1) {
                size +=  1;
                res = Math.max(res, size);
            } else if (n == m) {
                continue;
            } else {
                size = 1;
            }
        }
        return res;
    }
}
