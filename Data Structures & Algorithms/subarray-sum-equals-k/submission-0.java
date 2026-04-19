class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, currentSum = 0;
        Map<Integer, Integer> prefixesWithSum = new HashMap<>();
        prefixesWithSum.put(0, 1);

        for (int n: nums) {
            currentSum += n;
            int needToRemove = currentSum - k;
            res += prefixesWithSum.getOrDefault(needToRemove, 0);
            prefixesWithSum.put(currentSum, prefixesWithSum.getOrDefault(currentSum, 0) + 1);
        }

        return res;
    }
}