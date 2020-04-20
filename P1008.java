/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode bstFromPreorder(int[] preorder) {

    return util(preorder, 0, preorder.length - 1);
  }

  private TreeNode util(int[] preorder, int start, int end) {
    if (start > end) {
      return null;
    }
    if (start == end) {
      return new TreeNode(preorder[start]);
    }

    TreeNode root = new TreeNode(preorder[start]);
    int mid = start + 1;
    for (int i = start + 1; i < preorder.length; i++) {
      if (preorder[i] > preorder[start]) {
        break;
      } else {
        mid++;
      }
    }

    root.left = util(preorder, start + 1, mid - 1);
    root.right = util(preorder, mid, end);
    return root;
  }

}