package Homework1_RemoveDuplicatesFromSortedList_83;

/**
 * Created by junjin on 6/5/17.
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 *
 * Input :[]
 * Output:[]
 *
 * Input : 1->1->1
 * Output: 1
 *
 * Input : 1->2->2
 * Output: 1->2
 *
 * Input : 1->2->2->3
 * Output: 1->2->3
 *
 * Input : 1->1->2
 * Output: 1->2
 *
 * Time Complexity : O(N)
 * Space Complexity: O(1)
 *
 * Accepted Solutions Runtime Distribution
 * Runtime: 1 ms
 * Beats  : 17.83%
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;

        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null){
            if(slow.val!=fast.val){
                slow.next=fast;
                slow=slow.next;
            }
            fast=fast.next;
        }
        slow.next=null;
        return head;
    }
}
