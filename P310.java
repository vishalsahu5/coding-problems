class Solution {

    private HashMap<Integer, Integer> rootHeights;
    private HashMap<Integer, ArrayList<Integer>> adj;

    private int bfs(int n, int root) {

        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        int height = 0;
        boolean[] visited = new boolean[n];
        while (q.size() != 0) {
            height++;
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int node = q.remove();
                List<Integer> neighbors = adj.get(node);
                visited[node] = true;
                boolean flag = false;
                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        flag = true;
                        q.add(neighbor);
                    }
                }
            }
        }
        return height;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0) {
            return new ArrayList<Integer>();
        }
        if (edges == null || edges.length == 0) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++)
                result.add(i);
            return result;
        }

        adj = new HashMap<>();
        rootHeights = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            ArrayList<Integer> temp = adj.getOrDefault(edges[i][0], new ArrayList<>());
            temp.add(edges[i][1]);
            adj.put(edges[i][0], temp);
            temp = adj.getOrDefault(edges[i][1], new ArrayList<>());
            temp.add(edges[i][0]);
            adj.put(edges[i][1], temp);
        }

        for (int i = 0; i < n; i++) {
            rootHeights.put(i, bfs(n, i));
        }
        System.out.println(rootHeights);
        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minHeight = Math.min(minHeight, rootHeights.get(i));
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (rootHeights.get(i) == minHeight) {
                result.add(i);
            }
        }
        return result;
    }
}