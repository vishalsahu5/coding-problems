/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

  private int result;

  private void inorder(TreeNode root, int L, int R) {
    if (root == null)
      return;
    inorder(root.left, L, R);
    if (root.val >= L && root.val <= R) {
      result += root.val;
    }
    inorder(root.right, L, R);
  }

  public int rangeSumBST(TreeNode root, int L, int R) {
    result = 0;
    inorder(root, L, R);
    return result;
  }
}