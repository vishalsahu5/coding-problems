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
    private Map<Integer, Integer> depthToSum;
    
    public int deepestLeavesSum(TreeNode root) {
        depthToSum = new HashMap<>();
        util(root, 0);
        
        int maxDepth = 0;

        for (int depth : depthToSum.keySet()) {
            maxDepth = Math.max(depth, maxDepth);
        }
        return depthToSum.get(maxDepth);
    }
    
    private void util(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            depthToSum.put(depth, (depthToSum.getOrDefault(depth, 0) + root.val));
            return;
        }
        
        util(root.left, depth+1);
        util(root.right, depth+1);
    }
}