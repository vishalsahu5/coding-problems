/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev, curr, forw;
        prev = null;
        curr = head;
        forw = curr.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = forw;
            if (forw != null)
                forw = forw.next;
        }
        return prev;
    }
}