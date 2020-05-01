class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int i=0, j=0;
        boolean goingUp = true;
        int[] result = new int[matrix.length * matrix[0].length];
        int k = 0;
        while (k < result.length) {
            result[k] = matrix[i][j];
            k++;
            if (goingUp && (i == 0 || j == matrix[0].length-1)) {
                goingUp = false;
                if (j == matrix[0].length - 1) i++;
                else j++;
            } else if (!goingUp && (j == 0 || i == matrix.length - 1)) {
                goingUp = true;
                if (i == matrix.length - 1) j++;
                else i++;
            } else if (goingUp) {
                i--;
                j++;
            } else {
                i++;
                j--;
            }
        }
        return result;
    }
}