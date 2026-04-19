class Solution {
    public int subarraySum(int[] nums, int k) {
        int totalSubarraysWithSumK = 0;
        int runningSum = 0;
        Map<Integer, Integer> numberOfPrefixesWithSum = new HashMap<>();
        numberOfPrefixesWithSum.put(0, 1);

        for (int n: nums) {
            runningSum += n;
            int prefixSumRequired = runningSum - k;
            int matches = numberOfPrefixesWithSum.getOrDefault(prefixSumRequired, 0);
            totalSubarraysWithSumK += matches;
            numberOfPrefixesWithSum.put(runningSum, numberOfPrefixesWithSum.getOrDefault(runningSum, 0) + 1);
        }

        return totalSubarraysWithSumK;
    }
}