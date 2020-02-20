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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        HashMap<TreeNode, Integer> nodeToLevel = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> levelToNodes = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        nodeToLevel.put(root, 0);
        while (q.size() != 0) {
            TreeNode node = q.remove();
            int currLevel = nodeToLevel.get(node);
            if (node.left != null) {
                q.add(node.left);
                nodeToLevel.put(node.left, currLevel+1);
            }
            if (node.right != null) {
                q.add(node.right);
                nodeToLevel.put(node.right, currLevel+1);
            }
            ArrayList<Integer> temp = levelToNodes.getOrDefault(currLevel, new ArrayList<>());
            temp.add(node.val);
            levelToNodes.put(currLevel, temp);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<levelToNodes.size(); i++) {
            result.add(new ArrayList<>());
            result.set(i, levelToNodes.get(i));
        }
        Collections.reverse(result);
        return result;
    }
}