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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (list1 != null && list2 !=null){
            if (list1.val < list2.val){
                node.next = list1; //link the smaller node
                list1 = list1.next; //move the pointer in list1 forward
            }else{
                node.next = list2;
                list2 = list2.next;
            }

            node = node.next; //move our tail forward
        }

        /**Eventually, one list will run out of nodes before the other. 
        Since the lists were already sorted, we don't need to loop through the remaining nodes 
        of the other list—we just "staple" the rest of it to the end of our new list.
        */
        if (list1 != null){
            node.next = list1;
        }else{
            node.next = list2;
        }

        return dummy.next; //Since dummy was just a placeholder node with a value of 0, 
                            //the actual sorted list starts at dummy.next
    }
}