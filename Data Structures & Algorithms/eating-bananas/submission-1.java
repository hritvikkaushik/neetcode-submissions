class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = Arrays.stream(piles).max().getAsInt();
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (timeTaken(piles, mid) > h) {
                start = mid + 1;
            } else {
                res = mid;
                end = mid - 1;
            }
        }
        return res;
    }

    private int timeTaken(int[] piles, int k) {
        int t = 0;
        for (int i = 0; i < piles.length; i++) {
            t += (int) ((piles[i] + k - 1) / k);
        }
        return t;
    }
}

/* 
binary search over the solution space
max k = max of piles
min k = 1
search in this space
start = 1, end = max
res = -1
while start <= end
    mid = start + end / 2
    if time_taken(mid) > h
        start = mid + 1
    else if time_taken(mid) < h
        res = mid
        end = mid - 1

return res
*/