class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int i=0, j=0;
        // 1 - right, 2 - left, 3 - down, 4 - up
        int direction = 1;
        final int x = Integer.MIN_VALUE;
        while (result.size() < matrix.length * matrix[0].length) {
            result.add(matrix[i][j]);
            matrix[i][j] = x;
            if (direction == 1 && (j == matrix[0].length-1 || matrix[i][j+1] == x)) {
                direction = 3;
                i++;
            } else if (direction == 2 && (j == 0 || matrix[i][j-1] == x)) {
                direction = 4;
                i--;
            } else if (direction == 3 && (i == matrix.length-1 || matrix[i+1][j] == x)) {
                direction = 2;
                j--;
            } else if (direction == 4 && (i == 0 || matrix[i-1][j] == x)) {
                direction = 1;
                j++;
            } else if (direction == 1) {
                j++;
            } else if (direction == 2) {
                j--;
            } else if (direction == 3) {
                i++;
            } else if (direction == 4) {
                i--;
            }
        }
        return result;
    }
}