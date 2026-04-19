class Solution {
    public int trap(int[] arr) {
        final int N = arr.length;

        int l = 0, r = N - 1, l_max = 0, r_max = 0, total = 0;
        while (l < r) {
            int lh = arr[l], rh = arr[r];
            if (lh <= rh) {
                if (lh < l_max) {
                    total += l_max - lh;
                } else {
                    l_max = lh;
                }
                l++;
            } else {
                if (rh < r_max) {
                    total += r_max - rh;
                } else {
                    r_max = rh;
                }
                r--;
            }
        }

        return total;
    }
}
