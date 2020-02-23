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
    private int dfs(TreeNode root, int x, int depth) {
        if (root == null) return -1;
        
        if (root.val == x) return depth;
        
        int left = dfs(root.left, x, depth+1);
        int right = dfs(root.right, x, depth+1);
        if (left != -1) return left;
        if (right != -1) return right;
        return -1;
    }
    
    private TreeNode getParent(TreeNode root, int x, TreeNode parent) {
        if (root == null) return null;
        
        if (root.val == x) return parent;
        
        TreeNode lParent = getParent(root.left, x, root);
        TreeNode rParent = getParent(root.right, x, root);
        if (lParent != null) return lParent;
        else return rParent;
        
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        int xDepth = dfs(root, x, 0);
        int yDepth = dfs(root, y, 0);
        
        if (xDepth == yDepth && getParent(root, x, null) != getParent(root,y,null)) {
            return true;
        }
        return false;
    }
}