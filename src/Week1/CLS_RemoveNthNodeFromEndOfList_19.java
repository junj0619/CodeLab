/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode slow = dummyHead, fast = dummyHead;
        
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }                
               
        slow.next = slow.next.next;
        
        return dummyHead.next;
    }
}
