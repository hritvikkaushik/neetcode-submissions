class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        int max = 0;
        int l = 0, r = 1;
        while (r < n) {
            int profit = prices[r] - prices[l];
            max = Math.max(max, profit);
            if (prices[r] < prices[l]) {
                l = r;
            }
            r++;
        }
        return max;
    }
}
