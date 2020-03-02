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
        int result = 0;
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Integer> m = new HashMap<>();
        q.add(root);
        m.put(root, 1);
        while (q.size() != 0) {
            TreeNode currNode = q.remove();
            if (currNode.left == null && currNode.right == null) {
                result = m.get(currNode);
                break;
            }
            if (currNode.left != null) {
                q.add(currNode.left);
                m.put(currNode.left, m.get(currNode) + 1);
            }
            if (currNode.right != null) {
                q.add(currNode.right);
                m.put(currNode.right, m.get(currNode) + 1);
            }
        }
        return result;
    }
}