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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while(!allAreEmpty(lists)) {
            node.next = getSmallest(lists);
            node = node.next;
        }
        return dummy.next;
    }

    // Pick the smallest value from all the lists, and advance that list as well
    ListNode getSmallest(ListNode[] lists) {
        int smallest = -1;
        ListNode small = new ListNode(Integer.MAX_VALUE);

        // Find the smallest
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null && lists[i].val <= small.val) {
                small = lists[i];
                smallest = i;
            }
        }

        // Advance the smallest
        lists[smallest] = lists[smallest].next;
        return small;
    }

    boolean allAreEmpty(ListNode[] lists) {
        for (var list: lists) {
            if (list != null) {
                return false;
            }
        }
        return true;
    }
}
