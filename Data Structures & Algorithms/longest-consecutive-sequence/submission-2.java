class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        // Create a set of all numbers
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }

        // Iterate over set. 
        // If num - 1 is not present, it is the start of a sequence, so start counting. 
        // Else skip.
        int res = 1;
        int length = 1;
        for (var n: set) {
            if (set.contains(n - 1)) {
                continue;
            }
            while (set.contains(n + length)) {
                length += 1;
                res = Math.max(res, length);
            }
            length = 1;
        }
        return res;
    }
}

