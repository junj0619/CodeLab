/**
* beats : 59.74%
*
**/
public class LRUCache {
    
    class Node {
        int key;
        int val;
        Node pre;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }
    
    private HashMap<Integer, Node> map;
    private int cap;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head = new Node(Integer.MIN_VALUE, 0);
        tail = new Node(Integer.MAX_VALUE, 0);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            removeNode(node);
            addNodeAtHead(node);
            return node.val;
        }
        
    }
    
    public void put(int key, int value) {      
        
        Node cur = map.get(key);
        if (cur != null) {
            cur.val = value;
            removeNode(cur);
            addNodeAtHead(cur);
        } else {
            cur = new Node(key, value);
            if (map.size() == cap) {
                map.remove(tail.pre.key);
                removeNode(tail.pre);
            }
            addNodeAtHead(cur);
            map.put(key, cur);
        }
    }
    
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }
    
    private void addNodeAtHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
