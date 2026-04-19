class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i=0; i<n-2; ++i){
            if (i>0 && nums[i]==nums[i-1]) continue;
            int target = -nums[i];
            List<List<Integer>> twoSumRes = twoSum(nums, i + 1, target); 
            for (List<Integer> pair : twoSumRes) {
                pair.add(nums[i]);
                result.add(pair);
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int end = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                // Found a valid pair
                res.add(new ArrayList<>(Arrays.asList(nums[start], nums[end])));

                // Skip duplicates for nums[start] and nums[end]
                while (start < end && nums[start] == nums[start + 1]) start++;
                while (start < end && nums[end] == nums[end - 1]) end--;

                // Move pointers
                start++;
                end--;
            }
        }
        return res;
    }
}
