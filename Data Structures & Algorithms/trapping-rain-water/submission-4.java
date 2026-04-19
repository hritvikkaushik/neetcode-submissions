class Solution {
    public int trap(int[] heights) {
        int n = heights.length;
        int[] leftTaller = new int[n];
        leftTaller[0] = heights[0];

        int[] rightTaller = new int[n];
        rightTaller[n-1] = heights[n-1];

        for (int i = 1; i < n; i++) {
            leftTaller[i] = Math.max(leftTaller[i-1], heights[i]);
        }

        for (int i = n-2; i >= 0; i--) {
            rightTaller[i] = Math.max(rightTaller[i+1], heights[i]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            int stored = Math.min(leftTaller[i], rightTaller[i]) - heights[i];
            total += stored;
        }
        return total;
    }
}
