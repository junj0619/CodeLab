package Homework1_RemoveDuplicatesFromSortedListII_82;

/**
 * Created by junjin on 6/5/17.
 * Given a sorted linked list, delete all nodes that have duplicate numbers
 * ,leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 * Input : []
 * OutPut: []
 *
 * Input : 1->2->2->3
 * Output: 1->3
 *
 * Input : 1->1
 * Output: []
 *
 * Input : 1->1->1->2
 * Output: 2
 *
 * Input : 1->1->1->2->3->3
 * Output: 2
 *
 * Time Complexity : O(N) only iterative list once
 * Space Complexity: O(1) only create one dummyHead and three pointer variables
 *
 * Accepted Solutions Runtime Distribution
 * Runtime: 2 ms
 * Beats  : 6.17%
 */
public class RemoveDuplicatesFromSortedListII {
    public class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head==null||head.next==null) return head;

            ListNode dummyHead=new ListNode(head.val-1);
            dummyHead.next=head;

            ListNode fast=head;
            ListNode slow=dummyHead;
            ListNode first=dummyHead;


            while(fast.next!=null){
                if(slow.val!=fast.val && fast.val!=fast.next.val){
                    first.next=fast;
                    first=first.next;
                }
                slow=fast;
                fast=fast.next;
            }

            if(slow.val!=fast.val)
            {
                first.next=fast;
            }else{
                //[1,1] => [];
                first.next=null;
            }

            return dummyHead.next;
        }
    }
}
