## Design a HashMap ##

### Hash Collision solutions:  
1. Separate Chaining (following code)

2. Liner Probing

Following HashMap implementation using **Separate Chaining**(based on LinkedList) to resolve Hash Collision.

Following HashMap class provide three methods:
1. **Put**(String key, Integer value)
2. **Get**(String key)
3. **Remove**(String key)

```java

import java.util.ArrayList;

public class HashMap {

    class LinkedListNode {
        public String key;
        public Integer value;
        public LinkedListNode pre;
        public LinkedListNode next;

        public LinkedListNode(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<LinkedListNode> list = null;

    public HashMap(Integer size) {
        list = new ArrayList<LinkedListNode>(size);
        list.ensureCapacity(size);
        for (int i = 0; i < size; i++) { //make sure create null node otherwise list size will be 0
            list.add(null);
        }
    }


    public LinkedListNode put(String key, Integer value) {
        LinkedListNode existNode = getNode(key);
        if (existNode != null) {
            existNode.value = value;
            return existNode;
        }
        LinkedListNode newNode = new LinkedListNode(key, value);
        Integer index = getIndex(key);
        LinkedListNode firstNode = list.get(index);
        if (firstNode != null) {  //Use separate chaining to resolve Hash Collision
            firstNode.pre = newNode;
            newNode.next = firstNode;
        }
        list.set(index, newNode);
        return newNode;
    }

    public Integer get(String key) {
        LinkedListNode node = getNode(key);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    public LinkedListNode remove(String key) {
        LinkedListNode node = getNode(key);
        if (node != null) {
            int index = getIndex(key);
            if (node.pre == null) { //remove head
                list.set(index, node.next);
            } else {
                node.pre.next = node.next;
            }

            if (node.next != null) {
                node.next.pre = node.pre;
            }

            node.pre = null;
            node.next = null;
        }

        return node;
    }

    private int getIndex(String key) {
        return Math.abs(key.hashCode() % list.size());
    }

    private LinkedListNode getNode(String key) {
        LinkedListNode node = list.get(getIndex(key));
        if (node != null) {
            while (node != null) {
                if (node.key.equals(key)) {
                    return node;
                }
                node = node.next;
            }
        }
        return node;
    }

}


```
