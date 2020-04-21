/**
 * // This is the BinaryMatrix's API interface. // You should not implement it,
 * or speculate about its implementation interface BinaryMatrix { public int
 * get(int x, int y) {} public List<Integer> dimensions {} };
 */

class Solution {
  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    // return 0;
    int[] dims = binaryMatrix.dimensions();
    List<Integer> dims = binaryMatrix.dimensions();
    int m = dims.get(0), n = dims.get(1);
    int minCol = n;
    int i = 0, j = n - 1;
    while (minCol >= 0 && j >= 0 && i < m) {
      if (binaryMatrix.get(i, j) == 1) {
        minCol = Math.min(minCol, j);
        j--;
      } else {
        i++;
      }
    }
    return minCol == n ? -1 : minCol;
  }
}