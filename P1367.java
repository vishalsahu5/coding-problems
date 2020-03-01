/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public boolean isSubPath(ListNode head, TreeNode root) {
      if (root == null) return false;
      if (util(head, root)) return true;
      return isSubPath(head, root.left) || isSubPath(head, root.right);
  }
  
  public boolean util(ListNode head, TreeNode root) {
      if ((head == null && root == null) || head == null) return true;
      if (root == null && head != null) return false;
      
      if (head.val == root.val) {
          return util(head.next, root.left) || util(head.next, root.right);
      } else {
          return false;
      }
  }
}