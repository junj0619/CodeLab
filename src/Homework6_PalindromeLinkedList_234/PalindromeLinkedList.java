/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
            
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != null) {
            fast = fast.next;
        }
        
        ListNode after = reverseList(slow);
        
        while(after != null) {
            if(head.val != after.val) {
                return false;
            }
            head = head.next;
            after = after.next;
        }
        return true;
    }
    
    public ListNode reverseList(ListNode node){
                
        ListNode pre = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        
        return pre;        
    }
    
}
