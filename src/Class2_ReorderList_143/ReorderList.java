package Class2_ReorderList_143;

import java.util.List;

/**
 * Created by junjin on 6/12/17.
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reorderList(node1);
        while (node1 != null) {
            System.out.printf(node1.val + "->");
            node1 = node1.next;
        }

    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        /*
        1) Find the mid point of list
        2) Reverse second half of list
        3) Link first half and second half
        */

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slow = dummyNode, fast = dummyNode;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode cur = slow.next;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        slow.next = pre;


        ListNode first = head;
        ListNode second = pre;
        ListNode preMid = slow;

        while (first != preMid) {
            preMid.next = second.next;
            second.next = first.next;
            first.next = second;
            first = second.next;
            second = preMid.next;
        }
    }
}
