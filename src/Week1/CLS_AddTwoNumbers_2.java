/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// (9) + (1) => (0 -> 1)
// (9 -> 9 -> 9) + (1) => (0 -> 0 -> 0 -> 1)
// (5) + (5) => (0 -> 1)

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        
        int carry = 0;
        ListNode resultList = new ListNode(0);
        ListNode ans = resultList;
        
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;            
            carry = sum / 10;
            resultList.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            resultList = resultList.next;
        }
        
        addRemaining((l1 != null) ? l1 : l2, resultList, carry);       
        
        return ans.next;
     }
    
    private void addRemaining(ListNode list, ListNode result, int carry) {
        while (list != null) {
            int sum = list.val + carry;
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;
            list = list.next;
        }
    
         if (carry == 1) 
            result.next = new ListNode(1);                        
    }
}
