/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  int max;

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null)
      return 0;

    max = 0;
    height(root);
    return max;
  }

  public int height(TreeNode root) {
    if (root == null)
      return 0;

    int option1 = height(root.left);
    int option2 = height(root.right);

    max = Math.max(max, option1 + option2);

    return Math.max(option1, option2) + 1;
  }
}