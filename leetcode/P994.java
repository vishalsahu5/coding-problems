class Solution {

    private class Pair {
        public int first;
        public int second;

        public Pair(int i, int j) {
            first = i;
            second = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null)
            return 0;

        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, HashMap<Integer, Integer>> m = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            m.put(i, new HashMap<>());
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                    m.get(i).put(j, 0);
                }
            }
        }

        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        while (q.size() != 0) {

            Pair curr = q.remove();
            for (int i = 0; i < dirs.length; i++) {
                int newRow = curr.first + dirs[i][0];
                int newCol = curr.second + dirs[i][1];
                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
                    continue;
                } else {
                    if (grid[newRow][newCol] == 1) {
                        q.add(new Pair(newRow, newCol));
                        if (!m.containsKey(newRow))
                            m.put(newRow, new HashMap<>());
                        m.get(newRow).put(newCol, m.get(curr.first).get(curr.second) + 1);
                        grid[newRow][newCol] = 2;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    result = Math.max(result, m.get(i).get(j));
                } else if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return result;
    }
}