class Solution {
    public int maxArea(int[] heights) {
        int i=0, j=heights.length-1;
        int max = 0;
        while(i<j){
            int lh = heights[i];
            int rh = heights[j];
            int h = Math.min(lh, rh) * (j-i);
            max = Math.max(max, h);
            if(lh<rh){
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
