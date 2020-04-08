/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode slow = head, fast = slow.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast != null) {
      return slow.next;
    } else {
      return slow;
    }
  }
}