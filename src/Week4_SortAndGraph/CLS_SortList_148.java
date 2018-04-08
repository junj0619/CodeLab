/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left, right);
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head, pre = null;
        
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        pre.next = null;
        return slow;
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        if (left == null || right == null) return (left == null) ? right : left;
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }            
            cur = cur.next;
        }
        
        if (left != null) cur.next = left;
        if (right != null) cur.next = right;
                
        return dummy.next;        
    }
}
