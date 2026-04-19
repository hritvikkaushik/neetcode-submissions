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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode a = list1;
        ListNode b = list2;
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                node.next = a;
                a = a.next;
                node = node.next;
            } else {
                node.next = b;
                b = b.next;
                node = node.next;
            }
        }
        while (a != null) {
            node.next = a;
            a = a.next;
            node = node.next;
        }
        while (b != null) {
            node.next = b;
            b = b.next;
            node = node.next;
        }
        return dummy.next;
    }
}