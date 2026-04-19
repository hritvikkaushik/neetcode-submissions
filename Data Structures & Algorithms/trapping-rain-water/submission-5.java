class Solution {
    public int trap(int[] heights) {
        int l = 0, r = heights.length - 1;
        int leftMax = 0, rightMax = 0;
        int stored = 0;
        while (l < r) {
            if (heights[l] < heights[r]) {
                leftMax = Math.max(heights[l], leftMax);
                stored += leftMax - heights[l];
                l++;
            } else {
                rightMax = Math.max(heights[r], rightMax);
                stored += rightMax - heights[r];
                r--;
            }
        }
        return stored;
    }
}
