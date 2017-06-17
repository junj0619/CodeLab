package Class2_MergeTwoSortedLists_21;

/**
 * Created by junjin on 6/11/17.
 *
 * Input : L1 = []
 *         L2 = []
 * Output: []
 *
 * Input : L1 = 1->2->3->4
 *         L2 = []
 * Output: 1->2->3->4
 *
 * Input : L1 = []
 *         L2 = 1->2->3->4
 * Output: 1->2->3->4
 *
 * Input : L1 = 1->3->5->7
 *         L2 = 2->4->6->8
 * Output: 1->2->3->4->5->6->7->8
 *
 * Input : L1 = 1->2->3->4
 *         L2 = 2->6->7->9
 * Output: 1->2->2->3->4->6->7->9
 *
 * Time Complexity : O(n) because iterative l1 or l2 once (shorter one between l1 and l2)
 * Space Complexity: O(1) only create one dummyHead
 *
 * Accepted Solutions Runtime Distribution
 * Runtime: 16 ms
 * Your runtime beats 52.69 % of java submissions.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;
        /*
        * 1) Compare l1 with l2,
        *    Append smaller one to the dummyHead until one of l1 and l2 reach to the end
        *
        * 2) Check l1 and l2 current pointer which one doesn't reach to end.
        *    Append the one not in the end to the dummyHead end.
        * */
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

        if (l1 != null) {
            head.next = l1;
        } else if (l2 != null) {
            head.next = l2;
        }

        return dummyHead.next;
    }
}
