/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
  public TreeNode util(int[] preorder, int left, int right) {
    if (left > right)
      return null;

    TreeNode root = new TreeNode(preorder[left]);
    int i;
    for (i = left; i < preorder.length; i++) {
      if (preorder[i] > preorder[left])
        break;
    }
    root.left = util(preorder, left + 1, i - 1);
    root.right = util(preorder, i, right);
    return root;
  }

  public TreeNode bstFromPreorder(int[] preorder) {

    return util(preorder, 0, preorder.length - 1);
  }
}