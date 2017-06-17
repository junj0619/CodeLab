package Class2_ReverseLinkedListII_92;

/**
 * Created by junjin on 6/12/17.
 * <p>
 * <p>
 * Input : 1->2->3->4->5  m=2,n=4
 * Output: 1->4->3->2->5
 */
public class ReverseLinkedListII {

    public static void main(String args[]) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        int m = 2;
        int n = 4;

        ListNode node = reverse(node1, m, n);
        while (node != null) {
            System.out.printf(node.val + "->");
            node = node.next;
        }
    }

    public static ListNode reverse(ListNode head, int m, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode headNode = dummyHead;
       /* 1) Move to one Node ahead of Node m */
       /* 2) Reverse LinkedList from m to n */
        int i = 0;
        while (i < m - 1) {
            headNode = headNode.next;
            i++;
        }

        ListNode pre = headNode;
        ListNode start = pre.next;
        ListNode then = start.next;
        int j = 0;                    /* 1->2->3->4->5 */
                                      /* p  s  t */
        while (j < n - m + 1) {
            start.next = then.next;   /* 1->2->4->5  3 */ //Step 1
                                      /* p  s        t */

                                      /*    3 <-t      */
                                      /*    |          */
            then.next = pre.next;     /* 1->2->4->5    */ //Step 2
                                      /* p  s          */

            pre.next = then;          /* 1->3->2->4->5 */ //Step 3
                                      /* p  t  s       */

            then = start.next;        /* 1->3->2->4->5 */ //Step 4
                                      /* p     s  t    */
            j++;
        }

        return dummyHead.next;
    }
}
