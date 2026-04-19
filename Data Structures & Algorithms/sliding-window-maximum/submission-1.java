class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        
        Deque<Integer> q = new ArrayDeque<Integer>();
        int[] res = new int[n - k + 1];
        int i = 0;
        
        for (int j = 0; j < n; j++) {
            // Maintenance of deque for all windows (even when size < k in the beginning)
            while (!q.isEmpty() && nums[q.getLast()] < nums[j]) {
                q.removeLast();
            }
            q.addLast(j);
            if (q.getFirst() < j - k + 1) {
                q.removeFirst();
            }

            // Once window size is reached, start storing results
            if (j >= k - 1) {
                res[i++] = nums[q.getFirst()];
            }
        }
        return res;
    }
}
