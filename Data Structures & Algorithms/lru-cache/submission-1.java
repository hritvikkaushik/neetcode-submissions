class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node() {}

        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // Doubly Linked List used to maintain recency. 
    // head -> least recent. head is actually a dummy node. head -> next is the first
    Node head;
    // tail is also a dummy node. tail -> prev is the last.
    Node tail;

    int cap;
    int size;
    Map<Integer, Node> map; // map of key to node

    public LRUCache(int capacity) {
        head = new Node();
        head.next = tail;

        tail = new Node();
        tail.prev = head;

        map = new HashMap<>();
        cap = capacity;
        size = 0;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insert(node);
        } else {
            // System.out.println("Not in map: " + key);
            Node node = new Node(key, value);
            map.put(key, node);
            if (size == cap) {
                Node leastRecent = head.next;
                // System.out.println("Cache is at capacity, evicting least recent: " + leastRecent.key);
                remove(leastRecent);
                map.remove(leastRecent.key);
            }
            insert(node);
        }
    }

    private void insert (Node node) {
        Node lastNode = tail.prev;
        lastNode.next = node;
        node.prev = lastNode;
        node.next = tail;
        tail.prev = node;
        ++size;
    }

    private void remove (Node node) {
        Node previousNode = node.prev;
        Node nextNode = node.next;
        previousNode.next = nextNode;
        nextNode.prev = previousNode;
        --size;
    }
}
