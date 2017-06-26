/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /*
  *  Input : []
  *  Output: []
  *
  *  Input : [1]
  *  Output: [1]
  *
  *  Input : 2 -> 3 -> 4 -> 1
  *  Output: 1 -> 2 -> 3 -> 4 
  *
  *  Input : 1 -> 3 -> 2 -> 7
  *  Output: 1 -> 2 -> 3 -> 7
  *    
  *  Input : 4 -> 3 -> 2 -> 1
  *  Output: 1 -> 2 -> 3 -> 4
  *
  * Time Complexity : O(n2)
  * Space Complexity: O(1)
  *
  * Runtime: 43 ms
  * Beats: 31.30 %
  **/
public class Solution {
    public ListNode insertionSortList(ListNode head) {
       /*
        * Insertion Sort:
        * Divide array to two parts. Sorted portion and Unsorted portion
        * Each time new element to join sorted portion. We will put it in the correct position base on comparsion of sorted elements.
        * 
        * For this question:
        * Because the data is stored in the Singly LinkedList. We cannot do the backward iteration.
        * So that each item there is a new element join the sorted portion. We start from the left (list head).
        *
        * Find position logic:
        * If next sorted element val is greater than cur val. Then insert cur node before next sorted element.
        */
        if(head == null || head.next == null) return head;
        
        ListNode dummyHead = new ListNode(0);
        ListNode next;
        ListNode curr = head;
        ListNode pre = dummyHead;
        
        while(curr != null){
            next = curr.next;
            while(pre.next != null && pre.next.val < curr.val) {
                pre = pre.next;
            }
            
            curr.next = pre.next;
            pre.next = curr;
            pre = dummyHead;
            curr = next;
        }        
        return dummyHead.next;
    }
}
