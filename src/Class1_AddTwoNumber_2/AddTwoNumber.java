package Class1_AddTwoNumber_2;

/**
 * Created by junjin on 6/4/17.
 *
 * Input : (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: (7 -> 0 -> 8)
 *
 * Input : (8 -> 1) + (0)
 * Output: (8 -> 1)
 *
 * Input : Null + (1 -> 2)
 * Output: (1 -> 2)
 *
 * Input : Null + Null
 * Output: Null
 *
 * Input : (1 -> 2 -> 3) + (9 -> 8-> 6)
 * Output: (0 -> 1 -> 0 ->1)
 *
 * Time, Space Complexity: O(N) N is larger one in l1 and l2, O(N)
 * Accepted Solutions Runtime Distribution.
 * Beats 16.32%
 */
public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0);
        ListNode head = node;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            sum = sum + carry;
            carry = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
        }

        if (carry == 1) {
            node.next = new ListNode(1);
        }

        return head.next;
    }
}
