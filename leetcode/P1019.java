/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public int[] nextLargerNodes(ListNode head) {
    ListNode temp = head;
    int n = 0;
    while (temp != null) {
      temp = temp.next;
      n++;
    }
    int[] res = new int[n];
    Deque<int[]> stack = new LinkedList<>();
    int i = 0;
    while (head != null) {
      while (!stack.isEmpty() && stack.peek()[1] < head.val) {
        res[stack.pop()[0]] = head.val;
      }
      stack.push(new int[] { i, head.val });
      i++;
      head = head.next;
    }
    return res;
  }
}