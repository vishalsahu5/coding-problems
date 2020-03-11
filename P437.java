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
  private int dfs(TreeNode root, int sum, int k, HashMap<Integer, Integer> map) {
      if (root == null) return 0;
      
      sum += root.val;
      
      int count = map.getOrDefault(sum-k, 0);
      
      map.put(sum, map.getOrDefault(sum, 0) + 1);
      count += dfs(root.left, sum, k, map);
      count += dfs(root.right, sum, k, map);
      map.put(sum, Math.max(0, map.getOrDefault(sum, 0)-1));
      return count;
  }
  
  
  public int pathSum(TreeNode root, int sum) {
      if (root == null) return 0;
      HashMap<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);
      return dfs(root, 0, sum, map);
  }
}