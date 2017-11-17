/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {        
        if (head == null) return null;
        
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode smallerHead = l1, largerHead = l2;
        
        while (head != null) {
            if (head.val < x) {              
                l1.next = new ListNode(head.val);
                l1 = l1.next;
            } else {                
                l2.next = new ListNode(head.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        
        l1.next = largerHead.next;
        return smallerHead.next;
    }
}
