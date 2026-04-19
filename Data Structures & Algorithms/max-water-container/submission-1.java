class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int l = 0;
        int r = heights.length - 1;
        while (l < r) {
            int lh = heights[l];
            int rh = heights[r];
            int vol = Math.min(lh, rh) * (r - l);
            res = Math.max(res, vol);
            if (lh < rh) l++;
            else r--;
        }
        return res;
    }
}
