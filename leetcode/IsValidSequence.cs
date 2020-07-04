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
public class Solution {
    public bool IsValidSequence(TreeNode root, int[] arr) {
        if (root == null) {
            return arr.Length == 0;
        }
        return util(root, arr, 0);
    }
    
    private bool util(TreeNode root, int[] arr, int pos) {
        if (root == null) return false;
        if (pos == arr.Length - 1) {
            if (root != null && root.left == null && root.right == null) 
                return root.val == arr[pos];
            else 
                return false;
        }
        if (root.val == arr[pos])
            return util(root.left, arr, pos+1) || util(root.right, arr, pos+1);
        else
            return false;
    }
}