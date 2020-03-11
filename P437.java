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
    
    private HashMap<Integer, Integer> map;
    private int count;
    
    private void dfs(TreeNode root, int sum, int k) {
        if (root == null) return;
        
        sum += root.val;
        
        count += map.getOrDefault(sum-k, 0);
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        dfs(root.left, sum, k);
        dfs(root.right, sum, k);
        map.put(sum, Math.max(0, map.getOrDefault(sum, 0)-1));
    }
    
    
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        count = 0;
        map = new HashMap<>();
        map.put(0, 1);
        dfs(root, 0, sum);
        return count;
    }
}