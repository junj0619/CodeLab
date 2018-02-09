/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {                
        return reverseHelper(null, head);                 
    }
    //Approach #1: Tail recursion
    private ListNode reverseHelper(ListNode newHead, ListNode head) {
        if (head == null) return newHead;
        
        ListNode next = head.next;
        head.next = newHead;
        
        return reverseHelper(head, next);        
    }
    
    //Approach #2: Non-tail recursion
    public ListNode reverseList(ListNode head) {        
        if (head == null || head.next == null)
            return head;
        
        ListNode newHead = reverseList(head.next);
        
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    

}
