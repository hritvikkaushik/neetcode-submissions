/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node copy = new Node(101); // copy.next will point to the new list
        Node it1 = head;
        Node it2 = copy;
        while (it1 != null) {
            it2.next = new Node(it1.val);
            map.put(it1, it2.next);
            it1 = it1.next;
            it2 = it2.next;
        }
        // At this point we should have the singly linked list and a mapping of list1 nodes to list2 nodes
        // Now iterate again and clone the random pointers
        it1 = head;
        it2 = copy.next;
        while (it1 != null) {
            Node correspondingNode = it1.random != null ? map.get(it1.random) : null;
            it2.random = correspondingNode;
            it1 = it1.next;
            it2 = it2.next;
        }

        return copy.next;
    }
}
