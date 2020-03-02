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
  public int minDepth(TreeNode root) {
      
      if (root == null) return 0;
      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
      int height = 0;
      while (q.size() != 0) {
          height++;
          int size = q.size();
          for (int i=0; i < size; i++) {
              TreeNode currNode = q.remove();
              if (currNode.left == null && currNode.right == null) {
                  return height;
              }
              if (currNode.left != null) {
                  q.add(currNode.left);
              }
              if (currNode.right != null) {
                  q.add(currNode.right);
              }
          }
      }
      return height;
  }
}