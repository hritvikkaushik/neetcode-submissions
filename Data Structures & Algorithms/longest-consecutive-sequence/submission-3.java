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
        int res = 0;
        for (var n: set) {
            if (set.contains(n - 1)) {
                continue;
            }
            int current = n;
            int length = 1;
            while (set.contains(current + 1)) {
                current++;
                length++;
            }
            res = Math.max(res, length);
        }
        return res;
    }
}

