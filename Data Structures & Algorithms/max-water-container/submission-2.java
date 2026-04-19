class Solution {
    public int maxArea(int[] h) {
        int res = 0;
        int l = 0;
        int r = h.length - 1;
        while (l < r) {
            int lh = h[l];
            int rh = h[r];
            int vol = Math.min(lh, rh) * (r - l);
            res = Math.max(res, vol);
            if (lh < rh) l++;
            else r--;
        }
        return res;
    }
}
