class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();

        for (int end = 0; end < n; end++) {
            while(!q.isEmpty() && nums[q.peekLast()] < nums[end]) {
                q.removeLast();
            }
            q.addLast(end);
            int start = end - k + 1;
            if (start >= 0) {
                res[start] = nums[q.peekFirst()];
                if (start == q.peekFirst()) {
                    q.removeFirst();
                }
            }
        }

        return res;
    }
}
