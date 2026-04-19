class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length - 1;
        int l = 0, r = n;
        int max = 0;
        while(l < r && r >= 0 && l <= n) {
            int len = r - l;
            int area = Math.min(heights[l], heights[r]) * len;
            max = Math.max(area, max);
            if (heights[l] < heights[r]) l++;
            else r--;
        }
        return max;
    }
}
