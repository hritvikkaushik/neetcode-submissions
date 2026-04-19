class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minOpeningYet = prices[0];
        for (int price: prices) {
            int maxProfitIfSoldToday = price - minOpeningYet;
            res = Math.max(res, maxProfitIfSoldToday);
            minOpeningYet = Math.min(minOpeningYet, price);
        }
        return res;
    }
}
