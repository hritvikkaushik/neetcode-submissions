class Solution {
    public int maxProfit(int[] arr) {
        int maxP = 0;
        int minOpen = arr[0]; // minOpen represents the least price we have seen till now
        for (int close: arr) {
            maxP = Math.max(maxP, close - minOpen);
            minOpen = Math.min(minOpen, close);
        }
        return maxP;
    }
}
