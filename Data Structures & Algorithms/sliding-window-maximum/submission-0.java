class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        Deque<Integer> q = new ArrayDeque<Integer>();
        int[] res = new int[n-k+1];

        for (int j=0; j<n; j++) {
            int right = nums[j];
            while(!q.isEmpty() && nums[q.getLast()] < right) {
                q.removeLast();
            }
            q.addLast(j);

            if (j-i+1 == k) {
                res[i] = nums[q.getFirst()];
                
                int outgoing = q.getFirst();
                if (outgoing == i) {
                    q.removeFirst();
                }
                i++;
            }
        }
        return res;
    }
}
