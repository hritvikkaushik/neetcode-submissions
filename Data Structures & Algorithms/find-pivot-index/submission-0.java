class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 0;
        for(int i = 1; i < n; i++) {
            pre[i] = nums[i-1] + pre[i-1];
        }

        int[] suff = new int[n];
        suff[n-1] = 0;
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = nums[i+1] + suff[i+1];
        }

        for (int i = 0; i < n; i++) {
            if (pre[i] == suff[i]) {
                return i;
            }
        }
        
        return -1;
    }
}