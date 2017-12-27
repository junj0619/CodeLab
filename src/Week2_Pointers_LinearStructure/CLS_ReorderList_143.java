/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        /*
        * 1) find mid point
        * 2) reverse second half of list
        * 3) link first half with second half
        */
        
        
        if (head == null || head.next == null) return;
        
        ListNode dummyHead = new ListNode(0);    
        ListNode fast = dummyHead, slow = dummyHead;
        ListNode mid;
        dummyHead.next = head;
        
        //1) Find mid
        while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
        }        
        mid = slow.next;
        slow.next = null;
        //2) Reverse Second half
        ListNode secondHalf = reverseList(mid);
        
        //3) Link
        slow = dummyHead.next;
        ListNode next;
        ListNode secNext;
        while (slow != null && secondHalf != null) {
            next = slow.next;
            secNext = secondHalf.next;
            
            slow.next = secondHalf;
            secondHalf.next = next;
            slow = next;
            secondHalf = secNext;
        }
        
        head = dummyHead.next;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        
        while (cur != null) {
            next = cur.next;
            cur.next = pre;            
            pre = cur;
            cur = next;
        }   
        return pre;
    }
}
