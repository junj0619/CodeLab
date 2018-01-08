/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
// Approach #1 by HashMap
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>(); //Key: orginal node, value: new copy node
        RandomListNode headNode = head;
        RandomListNode curNode = null, nextNode = null, randomNode = null;
        
        while (headNode != null) {                       
            //1) Copy current node
            if (!map.containsKey(headNode)) {
                curNode = new RandomListNode(headNode.label);
                map.put(headNode, curNode);
            }
            //2) Copy next node
            if (headNode.next != null && !map.containsKey(headNode.next)) {
                nextNode = new RandomListNode(headNode.next.label);
                map.put(headNode.next, nextNode);
            }
            //3) Copy random node
            if (headNode.random != null && !map.containsKey(headNode.random)) {
                randomNode = new RandomListNode(headNode.random.label);
                map.put(headNode.random, randomNode);
            }
            //4) Copy mapping
            map.get(headNode).next = map.get(headNode.next);
            map.get(headNode).random = map.get(headNode.random);
            headNode = headNode.next;            
        }
        
        return map.get(head);        
    }
    
    //Approach 2# In-Place Copy
    public RandomListNode copyRandomList(RandomListNode head) {
        
        //step 1: copy current node in the next postion
        RandomListNode node = head;
        while(node != null){
           RandomListNode copy = new RandomListNode(node.label);
           RandomListNode next = node.next;
           node.next = copy;
           copy.next = next;
           node = next;
        }
        
        //step 2: link copy random pointer
        node = head;
        while(node != null && node.next != null){
            RandomListNode next = node.next.next;
            if(node.random != null){       //[1,#] no random. so have to check this case
                node.next.random = node.random.next;
            }
            node = next;
        }
        
        //step 3: rebuild link list to CopyLinkedList and Originial LinkedList
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode copy = dummyHead;
        RandomListNode original = head;
        node = head;
        while(node != null && node.next != null){
            RandomListNode next = node.next.next;
            copy.next = node.next;
            original.next = next;
            
            copy = copy.next;
            original = original.next;
            node = next;
        }
    
        return dummyHead.next;
    }
}
