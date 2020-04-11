/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null)
      return 0;
    int option1 = diameterOfBinaryTree(root.left);
    int option2 = diameterOfBinaryTree(root.right);
    return Math.max(option1, Math.max(option2, height(root.left) + height(root.right)));

  }

  public int height(TreeNode root) {
    if (root == null)
      return 0;

    return 1 + Math.max(height(root.left), height(root.right));
  }
}