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
    public void reorderList(ListNode head) {
        ListNode first = head;
        ListNode second = findMiddleOfList(head);
        // printList(second, "Second half: ");
        second = reverseList(second);
        // printList(second, "Reversed second half: ");
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
        // printList(head, "Final: ");
    }

    private ListNode findMiddleOfList(ListNode head) {
        var slow = head; 
        var fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        return second;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode node = head;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

    // private void printList(ListNode head, String msg) {
    //     String out = msg;
    //     while (head != null) {
    //         out += head.val + " ";
    //         head = head.next;
    //     }
    //     System.out.println(out);
    // }
}
