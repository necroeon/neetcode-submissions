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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        ListNode slow = dummy;
        ListNode fast = dummy;

        // STEP 1: Give fast an 'n' node head start
        for (int i = 0; i < n; i++){
            fast = fast.next;
        }
        
        // STEP 2: Move both until fast reaches the last node
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        // STEP 3: The Deletion
        // slow.next is the target. We skip it!
        slow.next = slow.next.next;

        // STEP 4: Return the result
        // We return dummy.next because the original 'head' might have been deleted!
        return dummy.next;
    }
}
