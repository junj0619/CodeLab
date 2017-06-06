package Class1_PartitionList_86;

/**
 * Created by junjin on 6/4/17.
 *
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 * You should preserve the original relative order of the nodes in each of the two partitions.

 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 *
 * Input : [], x=0
 * Output: []
 *
 * Input : 2->3, x=1
 * Output: 2->3
 *
 * Input : 2->3, x=4
 * Output: 2->3
 *
 * Input : 2->1, x=2
 * Output: 1->2
 *
 * Input : 1->4->3->2->5->2, x=3
 * Output: 1->2->2->4->3->5
 *
 * Accepted Solutions Runtime Distribution
 * Runtime: 1 ms, Beats:7.98%
 *
 */

public class PartitionList {
        public ListNode partition(ListNode head, int x) {
            if(head==null) return null;

            ListNode first=new ListNode(0);
            ListNode second=new ListNode(0);
            ListNode firstHead=first;
            ListNode secondHead=second;

            while(head!=null){
                if(head.val<x){
                    first.next=head;
                    first=first.next;
                }else{
                    second.next=head;
                    second=second.next;
                }
                head=head.next;
            }
        /*[2,1] x=2 */
        /*first:[1],second:[2,1]*/
        /*so that need to clean up second end node.next=null to avoid creating cycle on the new list*/
            second.next=null;
            first.next=secondHead.next;
            return firstHead.next;
        }
}
