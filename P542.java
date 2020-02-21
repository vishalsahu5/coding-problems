class Solution {
    
    private int dfs(int i, int j, boolean[][] visited, int[][] matrix, int[][] output) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
            return 10001;
        if (matrix[i][j] == 0) {
            return 0;
        }
        if (output[i][j] != -1) {
            return output[i][j];
        }
        
        visited[i][j] = true;
        int top=10001,bottom=10001,left=10001,right=10001;
        if (i > 0 && !visited[i-1][j])
            top = 1 + dfs(i-1, j, visited, matrix, output);
        if (i < matrix.length - 1 && !visited[i+1][j])
            bottom = 1 + dfs(i+1, j, visited, matrix, output);
        if (j > 0 && !visited[i][j-1])
            left = 1 + dfs(i, j-1, visited, matrix, output);
        if (j < matrix[0].length-1 && !visited[i][j+1])
            right = 1 + dfs(i, j+1, visited, matrix, output);
        
        visited[i][j]=false;
        return Math.min(top, Math.min(bottom, Math.min(left,right)));
    }
    
    public int[][] updateMatrix(int[][] matrix) {
        
        int[][] output = new int[matrix.length][matrix[0].length];
        for (int i=0; i<output.length; i++) {
            for (int j=0; j<output[0].length; j++) {
                output[i][j] = -1;
            }
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                output[i][j] = dfs(i, j, visited, matrix, output);
            }
        }
        return output;
    }
}