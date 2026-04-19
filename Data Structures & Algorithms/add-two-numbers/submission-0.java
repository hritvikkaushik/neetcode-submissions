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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode i1 = l1, i2 = l2, s = sum;
        int carry = 0;
        while (i1 != null && i2 != null) {
            int digitSum = i1.val + i2.val + carry;
            s.next = new ListNode(digitSum % 10);
            
            carry = digitSum / 10;
            s = s.next;
            i1 = i1.next;
            i2 = i2.next;
        }

        if (i2 != null) {
            i1 = i2;
        }

        while (i1 != null) {
            int digitSum = i1.val + carry;
            s.next = new ListNode(digitSum % 10);

            carry = digitSum / 10;
            s = s.next;
            i1 = i1.next;
        }

        if (carry > 0) {
            s.next = new ListNode(carry);
        }

        return sum.next;
    }
}
