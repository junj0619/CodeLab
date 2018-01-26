/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return partition(lists, 0, lists.length - 1);       
    }
    
    private ListNode partition(ListNode[] lists, int s, int e) {
        if (s == e) return lists[s];        
                
        int m = (s + e) >>> 1;
        ListNode l1 = partition(lists, s, m);
        ListNode l2 = partition(lists, m + 1, e);
        return mergTwoLists(l1, l2);        
    }
    
    private ListNode mergTwoLists(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while (l1 != null && l2 != null) {                            
                if (l1.val < l2.val) {
                    head.next = l1;                    
                    l1 = l1.next;
                } else {
                    head.next = l2;
                    l2 = l2.next;
                }
                head = head.next;                                    
            }
            
        if (l1 != null)
            head.next = l1;
        if (l2 != null)
            head.next = l2;
        
        return dummy.next;                
    }
}
