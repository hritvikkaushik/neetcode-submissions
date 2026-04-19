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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = dummy, slow = dummy;

        while (true) {
            int counter = 0;

            // check if k nodes exist
            while (counter < k && fast.next != null) {
                fast = fast.next;
                counter++;
            }

            if (counter < k) return dummy.next;

            ListNode post = fast.next;
            ListNode first = slow.next;

            slow.next = reverse(first, post);

            slow = first;
            fast = first;
        }
    }

    private ListNode reverse(ListNode first, ListNode post) {
        ListNode prev = post;
        ListNode node = first;

        while (node != post) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}
