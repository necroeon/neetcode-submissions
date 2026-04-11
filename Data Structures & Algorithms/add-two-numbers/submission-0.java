/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            // 1. Get values (careful: what if l1 is null?)
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            // 2. Calculate sum and new carry
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            
            // 3. Create the new node and move the 'curr' pointer
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            // 4. Move l1 and l2 forward if they aren't null

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }

        return dummy.next;
    }
}
