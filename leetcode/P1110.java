/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private ArrayList<TreeNode> result;
    private HashMap<TreeNode, TreeNode> parent;
    private ArrayList<TreeNode> listOfNodesToDelete;
    private HashSet<Integer> setOfNodesToDelete;

    private void util(TreeNode root) {
        if (root == null)
            return;

        parent.put(root.left, root);
        parent.put(root.right, root);

        if (setOfNodesToDelete.contains(root.val))
            listOfNodesToDelete.add(root);

        util(root.left);
        util(root.right);
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }
        parent = new HashMap<>();
        listOfNodesToDelete = new ArrayList<>();
        setOfNodesToDelete = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) {
            setOfNodesToDelete.add(to_delete[i]);
        }
        parent.put(root, null);
        util(root);

        result = new ArrayList<>();
        if (!setOfNodesToDelete.contains(root.val))
            result.add(root);

        for (TreeNode node : listOfNodesToDelete) {
            System.out.println(node.val);
            TreeNode par = parent.get(node);
            if (par != null) {
                if (par.left != null && par.left.val == node.val) {
                    par.left = null;
                }
                if (par.right != null && par.right.val == node.val) {
                    par.right = null;
                }
            }
            if (node.left != null && !setOfNodesToDelete.contains(node.left.val))
                result.add(node.left);
            if (node.right != null && !setOfNodesToDelete.contains(node.right.val))
                result.add(node.right);
            node = null;
        }
        result.removeAll(Collections.singleton(null));

        return result;
    }
}