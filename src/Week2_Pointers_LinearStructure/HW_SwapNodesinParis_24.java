/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode first;
        ListNode second;
        
        while (cur.next != null && cur.next.next != null) {
            first = cur.next;
            second = cur.next.next;
            
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = cur.next.next;            
        }
        
        return dummy.next;
    }
}
