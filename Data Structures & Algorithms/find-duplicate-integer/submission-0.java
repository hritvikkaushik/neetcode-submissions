class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            fast = nums[fast];
            fast = nums[fast];
            slow = nums[slow];
        } while (slow != fast);
        // At this point, fast and slow are equidistant from the start of the cycle
        // we restart fast from the head of the list, and advance one-at-a-time
        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
