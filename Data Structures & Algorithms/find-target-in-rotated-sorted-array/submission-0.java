class Solution {
    public int search(int[] nums, int target) {
        int minIndex = findMinElement(nums);
        int searchLeft = search(nums, 0, minIndex - 1, target);
        int searchRight = search(nums, minIndex, nums.length-1, target);
        return Math.max(searchLeft, searchRight);
    }

    int findMinElement (int[] nums) {
        int n = nums.length;
        if (nums[0] <= nums[n-1]) return 0;
        int start = 0, end = n-1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] < nums[(mid - 1 + n) % n] && nums[mid] < nums[(mid + 1) % n]) {
                res = mid;
                break;
            } else if (nums[mid] < nums[0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    int search (int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
