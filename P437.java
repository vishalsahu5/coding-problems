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
    
    private HashMap<Integer, Integer> set;
    private int count;
    
    private void dfs(TreeNode root, int sum, int k) {
        if (root == null) return;
        
        sum += root.val;
        if (set.containsKey(sum - k)) {
            count += set.get(sum-k);
        }
        set.put(sum, set.getOrDefault(sum, 0) + 1);
        dfs(root.left, sum, k);
        dfs(root.right, sum, k);
        set.put(sum, Math.max(0, set.getOrDefault(sum, 0)-1));
    }
    
    
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        count = 0;
        set = new HashMap<>();
        set.put(0, 1);
        dfs(root, 0, sum);
        return count;
    }
}