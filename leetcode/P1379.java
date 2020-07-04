/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
  private TreeNode result;

  private void util(TreeNode original, TreeNode cloned, TreeNode target) {
    if (original == null)
      return;
    if (result != null)
      return;
    if (original == target) {
      result = cloned;
      return;
    }
    util(original.left, cloned.left, target);
    util(original.right, cloned.right, target);
  }

  public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    result = null;
    util(original, cloned, target);
    return result;
  }
}