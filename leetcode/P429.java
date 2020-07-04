/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        HashMap<Node, Integer> nodeToLevel = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> levelToNodes = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        nodeToLevel.put(root, 0);
        while (q.size() != 0) {
            Node node = q.remove();
            int currLevel = nodeToLevel.get(node);
            for (Node n : node.children) {
                q.add(n);
                nodeToLevel.put(n, currLevel+1);
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
        return result;
    }
}