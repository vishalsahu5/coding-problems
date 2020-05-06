/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode prev, forw, curr;
    curr = head;
    prev = null;
    forw = curr.next;
    while (forw != null) {
      curr.next = prev;
      prev = curr;
      curr = forw;
      forw = forw.next;
    }
    curr.next = prev;
    return curr;
  }

  public int getDecimalValue(ListNode head) {
    ListNode temp = reverse(head);
    int result = 0, i = 0;
    while (temp != null) {
      result += (int) Math.pow(2, i) * temp.val;
      temp = temp.next;
      i++;
    }
    return result;
  }
}