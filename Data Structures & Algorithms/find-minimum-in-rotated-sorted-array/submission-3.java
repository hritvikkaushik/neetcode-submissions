class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        if (nums[l] <= nums[r]) return nums[0];
        int res = Integer.MAX_VALUE;

        while (l <= r) {
            int m = l + (r-l)/2;
            if(nums[(m-1+n)%n] > nums[m] && nums[(m+1)%n] > nums[m]) {
                res = nums[m];
                break;
            } else if (nums[0] > nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return res;
    }
}
