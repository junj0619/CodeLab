/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
/** For example,
  * Given 1->1->2, return 1->2.
  * Given 1->1->2->3->3, return 1->2->3.
*/
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode dummyNode = new ListNode(0);
        ListNode pre = dummyNode;
        ListNode cur = head;
        dummyNode.next = head;
        
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            
            pre.next = cur;
            pre = pre.next;
            cur = cur.next;
        }
        
        return dummyNode.next;        
    }
}
