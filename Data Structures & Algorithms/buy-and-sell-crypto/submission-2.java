class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minOpen = prices[0];
        for (int close: prices) {
            maxP = Math.max(maxP, close - minOpen);
            minOpen = Math.min(minOpen, close);
        }
        return maxP;
    }
}
