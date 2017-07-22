
//Logic Description refer from Jia Lu
//data structure used: 
//1. keyValueMap is used to maintain the key value pair
//2. keyNodeMap is used to maintain the key with its corresponding node in the doubly linked list
//3. doublylinked list is used to maintain the frequency of the each key, in each node, keep, the frequency, key and a linkedhashset
//why use linkedHashSet?
// for the situation when there are multiple keys with the least frequency when doing
//the remove, linkedhashset keeps the sequence of insertion, so the oldest one will be at the front of the linked hashset 

//get(key)
//1. if the key exist, get the value from the keyvaluemap and increase the freqency in the doubly linked list
//2. otherwise, return -1;

//put(key, value)
//1. if the key exist, override the value in the keyValueHashmap and increase the frequency in the doubly linkedlist
//2. If not
//    1. if reaches capacity, remove the old ones first and add the new one, should add it to the head of the doubly 
//    linked list and then increase the frequency
//    2. simply add the new one, should add it to the head of the doubly linked list and then increase the frequency



//increase Frequency(key)

//remove the key from the keyNodehashMap first
//add the key to the currentCount + 1' s node in the doubly linked list
//update the keyNode hash
//if the head's keyset is empty, remove the head node


//Time Complexity:

//get(key:O(1))

//put(key, value) :O(1)




public class LFUCache {
    
    class Node {        
        int freq;
        
        Node pre;
        Node next;
        
        LinkedHashSet<Integer> keys;
            
        public Node(int freq) {
            this.freq = freq;
            keys = new LinkedHashSet<Integer>();
            pre = null;
            next = null;
        }
    }
        
    private HashMap<Integer, Integer> valueMap;
    private HashMap<Integer, Node> nodeMap;
    private Node head;
    private int cap;
    
    public LFUCache(int capacity) {
        valueMap = new HashMap<>();
        nodeMap = new HashMap<>();
        head = null;
        cap = capacity;
    }
    
    public int get(int key) {
        if(valueMap.containsKey(key)) {           
            increaseFreq(key);
            return valueMap.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cap == 0) return;
        
        if(valueMap.containsKey(key)) {
            valueMap.put(key, value);            
        } else {
            if (valueMap.size() == cap) {
                removeOld();   
                addAtHead(key);
            } else {
                addAtHead(key);
            }
            valueMap.put(key, value);
        }        
        increaseFreq(key);        
    }
    
    private void addAtHead(int key) {
        if (head == null) {
            head = new Node(0);
            head.keys.add(key);
        } else if (head.freq > 0) {
            Node temp = new Node(0);
            temp.keys.add(key);
            
            temp.next = head;
            head.pre = temp;
            head = temp;
        } else {
            head.keys.add(key);
        }  
        nodeMap.put(key, head);        
    }
    
    private void increaseFreq(int key) {
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        
        if (node.next == null) {
            node.next = new Node(node.freq + 1);
            node.next.keys.add(key);
            node.next.pre = node;
        } else if (node.freq + 1 == node.next.freq) {
            node.next.keys.add(key);
        } else {
            Node temp = new Node(node.freq + 1);
            temp.keys.add(key);
            
            temp.next = node.next;
            temp.pre = node;
            node.next.pre = temp;
            node.next = temp;
        }
        
        nodeMap.put(key, node.next);
        
        if (node.keys.size() == 0) {
             remove(node);
        }
    }
    
    private void remove(Node node) {
        if (node.pre == null) {
            head = node.next;
        } else {
            node.pre.next = node.next;
        }
        
        if(node.next != null) {
            node.next.pre = node.pre;
        }    
    }
    private void removeOld() {
        if (head == null) return;
        
        int old = 0;
        for(int i : head.keys) {
            old = i;
            break;
        }
        
        head.keys.remove(old);
        if(head.keys.size() == 0) {
            remove(head);    
        }
        
        valueMap.remove(old);
        nodeMap.remove(old);
        
    }
    

    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
