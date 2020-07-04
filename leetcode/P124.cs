/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution
{
  public int MaxPathSum(TreeNode root)
  {
    int res = Int32.MinValue;
    findMax(root, ref res);
    return res;
  }

  private int findMax(TreeNode root, ref int res)
  {
    if (root == null)
    {
      return 0;
    }
    int l = findMax(root.left, ref res);
    int r = findMax(root.right, ref res);
    int maxSingle = Math.Max(Math.Max(l, r) + root.val, root.val);
    int maxBoth = Math.Max(l + r + root.val, maxSingle);

    res = Math.Max(maxBoth, res);
    return maxSingle;
  }
}