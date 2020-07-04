class Solution {

    class Pair {
        public int first;
        public int second;

        public Pair(int i, int j) {
            first = i;
            second = j;
        }

    }

    public int[][] updateMatrix(int[][] matrix) {

        int[][] output = new int[matrix.length][matrix[0].length];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] != 0)
                    output[i][j] = Integer.MAX_VALUE;
                else {
                    // output[i][j] = 0;
                    q.add(new Pair(i, j));
                }
            }
        }

        // start bfs
        while (q.size() != 0) {
            Pair p = q.remove();
            if (p.first > 0 && output[p.first - 1][p.second] > output[p.first][p.second] + 1) {
                q.add(new Pair(p.first - 1, p.second));
                output[p.first - 1][p.second] = output[p.first][p.second] + 1;
            }
            if (p.first < matrix.length - 1 && output[p.first + 1][p.second] > output[p.first][p.second] + 1) {
                q.add(new Pair(p.first + 1, p.second));
                output[p.first + 1][p.second] = output[p.first][p.second] + 1;
            }

            if (p.second > 0 && output[p.first][p.second - 1] > output[p.first][p.second] + 1) {
                q.add(new Pair(p.first, p.second - 1));
                output[p.first][p.second - 1] = output[p.first][p.second] + 1;
            }
            if (p.second < matrix[0].length - 1 && output[p.first][p.second + 1] > output[p.first][p.second] + 1) {
                q.add(new Pair(p.first, p.second + 1));
                output[p.first][p.second + 1] = output[p.first][p.second] + 1;
            }
        }
        return output;
    }
}