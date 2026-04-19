class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> longest = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (!longest.containsKey(n)) {
                var prev = longest.getOrDefault(n - 1, 0);
                var next = longest.getOrDefault(n + 1, 0);
                var cur = prev + 1 + next;
                longest.put(n, cur);
                longest.put(n - prev, cur);
                longest.put(n + next, cur);
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}
