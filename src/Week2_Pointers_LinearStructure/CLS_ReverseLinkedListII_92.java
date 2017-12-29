/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 //One Pass solution
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy, start = null, then = null;
        // dummy -> 1 -> 2 -> 3 -> 4 -> 5; m = 2; n = 4  ---> pre = 1, start = 2, then = 3        
        for (int i = 1; i < m; i++) pre = pre.next;        
        start = pre.next;
        then = start.next;
        
        for (int k = 1; k <= n - m; k++) {      // first iteration: dummy -> 1 -> 3 -> 2 -> 4 -> 5
            start.next = then.next;             //second iteration: dummy -> 1 -> 4 -> 3 -> 2 -> 5
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
}
