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
}
