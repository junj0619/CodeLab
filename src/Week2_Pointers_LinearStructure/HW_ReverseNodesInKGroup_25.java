/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //4 Pointers
    //D -> 1 -> 2 -> 3 -> 4 -> 5 , k = 3
    //c   (s,e)
    //c    s e ----> e    n  reverse nodes from start to end
    //===================================================
    //D -> 3 -> 2 -> 1 -> 4 -> 5
    //               c 
    //                   (s,e)
    //                c   s,e->e  n = null
    //===================================================
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur, start, end, next;
        cur = dummy;        
        
        while (cur.next != null) {            
            start = cur.next;
            end = cur.next;
            int i = 1;
            
            while (i < k && end.next != null) {
                end = end.next;
                i++;
            }
            
            next = end.next;
            
            if (i == k && k > 1) {                
                ListNode newHead = reverse(start, k);
                cur.next = newHead;
                start.next = next;
            }            
            cur = start;
        }
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode node, int k) {        
        ListNode pre = null, cur = node, next;                                
        int i = 0;
        
        while (i < k) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            i++;
        }
        return pre;        
    }
}
