/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int sumEvenGrandparent(TreeNode root) {
    if (root == null)
      return 0;

    int sum = 0, left = 0, right = 0;
    left = sumEvenGrandparent(root.left);
    right = sumEvenGrandparent(root.right);
    if (root.val % 2 == 0) {
      if (root.left != null && root.left.left != null)
        sum += root.left.left.val;
      if (root.left != null && root.left.right != null)
        sum += root.left.right.val;
      if (root.right != null && root.right.left != null)
        sum += root.right.left.val;
      if (root.right != null && root.right.right != null)
        sum += root.right.right.val;
    }
    return sum + left + right;
  }
}