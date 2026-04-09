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
    public void reorderList(ListNode head) {
        // Safety check: If list is empty or only has 1-2 nodes, no reordering needed
        if (head == null || head.next == null || head.next.next == null) return;

        // --- STEP 1: FIND THE MIDDLE ---
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // --- STEP 2: REVERSE THE SECOND HALF ---
        // 'slow' is at the start of the second half. Let's flip it.
        ListNode curr = slow.next; 
        slow.next = null; // Important: Cut the first half from the second half!
        
        ListNode prev = null;
        while (curr != null) {
            ListNode nextTemp = curr.next; // Bookmark the next node
            curr.next = prev;              // Flip the arrow
            prev = curr;                   // Move prev forward
            curr = nextTemp;               // Move curr forward
        }

        // --- STEP 3: ZIP/MERGE THE TWO HALVES ---
        // First half starts at 'head', Second (reversed) half starts at 'prev'
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode tmp1 = first.next;  // Bookmark first half's next
            ListNode tmp2 = second.next; // Bookmark second half's next

            first.next = second;         // Connect Left to Right
            second.next = tmp1;          // Connect Right to Left's original next

            first = tmp1;                // Move pointers forward
            second = tmp2;
        }
    }
}
