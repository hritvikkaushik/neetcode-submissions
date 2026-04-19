/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = new ListNode(-1, head);
        ListNode prev = new ListNode(-1, slow);
        int gap = 1;
        // build a gap of n between slow and fast
        while (gap < n) {
            fast = fast.next;
            ++gap;
        }
        // move the pointers so that slow points to nth node from the end.
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            prev = prev.next;
        }
        // now delete slow
        prev.next = slow.next;
        return slow == head ? prev.next : head;
    }
}
