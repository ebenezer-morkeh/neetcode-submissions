class LRUCache {

    private class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) { this.key = key; this.val = val;}
    }

    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(0, 0);
    private Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if( node == null) return -1;
        remove(node);
        addToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            node.val = value;
            remove(node);
            addToFront(node);
            return;
        }

        if(map.size() == capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node fresh = new Node(key, value);
        map.put(key, fresh);
        addToFront(fresh);
    }
}
