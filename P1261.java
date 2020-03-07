/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    
    private HashSet<Integer> setOfNodes;

    private void dfs(TreeNode root) {
        if (root == null) return;
        
        setOfNodes.add(root.val);
        if (root.left != null) {
            root.left.val = (2 * root.val) + 1;
        }
        if (root.right != null) {
            root.right.val = (2 * root.val) + 2; 
        }
        dfs(root.left);
        dfs(root.right);
    }
    
    public FindElements(TreeNode root) {
        if (root == null) {
            return;
        }
        setOfNodes = new HashSet<>();
        root.val = 0;
        dfs(root);
    }
    
    public boolean find(int target) {
        return setOfNodes.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */