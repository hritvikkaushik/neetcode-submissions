// window: [start, end)
// window size: end - start
// end - start == k => start = end - k
// number of elements = n => size of result array = ??

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();

        for (int end = 1; end <= n; end++) {
            while(!q.isEmpty() && nums[q.peekLast()] < nums[end - 1]) {
                q.removeLast();
            }
            q.addLast(end - 1);
            int start = end - k;
            if (start >= 0) {
                res[start] = nums[q.peekFirst()];
                while (!q.isEmpty() && q.peekFirst() <= start) {
                    q.removeFirst();
                }
            }
        }

        return res;
    }
}
