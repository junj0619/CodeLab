/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
/*
* [] => []
* [1, 1] => []
* [1, 2, 2, 3, 3, 4] => [1, 4]
* [1] => [1]
* [1, 1, 2] => [2]
*
* Idea: Use two pointer to compare pre val and cur.next val ( pre-->cur-->cur.next ) 
*       If same means duplicate need to be remove.
*/
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;     
        ListNode cur = head;   
        dummyHead.next = head;
        
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) { //Pre process input eg. [1, 1, 2] => [1, 2]
                cur = cur.next;
            }
            
            if (pre.next == cur) { // if pre pointer next is same like before means no duplicated yet
                pre = pre.next;
            } else {
                pre.next = cur.next; // else pre pointer should point to new cur.next [2]
            }            
            cur = cur.next;
        }                 
        
        return dummyHead.next;
    }
}
