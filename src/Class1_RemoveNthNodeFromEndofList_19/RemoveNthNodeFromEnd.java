package Class1_RemoveNthNodeFromEndofList_19;

/**
 * Created by junjin on 6/4/17.
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * Input : [], n=1
 * Result: []
 *
 * Input : [1], n=1
 * Result: []
 *
 * Input : [1->2->3->4->5], n=2
 * Result: [1->2->3->5]
 *
 * Input : [1->2], n=2
 * Result: [2]
 *
 * Input : [1->2], n=1
 * Result: [1]
 *
 * Time Complexity : O(N)
 * Space Complexity: O(1)
 *
 * Accepted Solutions Runtime Distribution
 * Runtime: 16 ms, Beats: 44.32%
 */
public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fast = dummyNode, slow = dummyNode;

        int i = 1;
        while (i <= n) {
            fast = fast.next;
            i++;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummyNode.next;
    }

}
