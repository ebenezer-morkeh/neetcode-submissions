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
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode before = null;

        while(secondHalf != null){
            ListNode after = secondHalf.next;
            secondHalf.next = before;
            before = secondHalf;
            secondHalf = after;
        }
        secondHalf = before;

        //Merge 
        ListNode firstHalf = head;

        while(secondHalf != null){
            ListNode next1 = firstHalf.next;
            ListNode next2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = next1;
            firstHalf = next1;
            secondHalf = next2;

        }

    }
}
