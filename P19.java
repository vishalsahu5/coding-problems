/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null)
      return head;
    ListNode left = head, right = head;
    int count = 0;
    while (count < n) {
      right = right.next;
      count++;
    }
    if (right == null)
      return head.next;
    while (right.next != null) {
      right = right.next;
      left = left.next;
    }
    left.next = left.next.next;
    return head;
  }
}
// 1 2