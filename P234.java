/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode revHead = slow;
    if (fast == null) {
      // even case
      revHead = reverse(slow);
    } else {
      // odd case
      revHead = reverse(slow.next);
      slow = null;
    }
    ListNode temp = head, revTemp = revHead;
    while (temp != null && revTemp != null) {
      if (temp.val != revTemp.val)
        return false;
      temp = temp.next;
      revTemp = revTemp.next;
    }
    return true;
  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode prev = null, curr = head, forw = head.next;
    while (forw != null) {
      curr.next = prev;
      prev = curr;
      curr = forw;
      forw = forw.next;
    }
    curr.next = prev;
    return curr;
  }

}