class Solution {
  private static long dp[][];

  private long solve(int[][] grid, int i, int j) {
    if (i >= grid.length || j >= grid[0].length) {
      return Integer.MAX_VALUE;
    }
    if (i == grid.length - 1 && j == grid[0].length - 1) {
      return grid[i][j];
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    } else {
      dp[i][j] = (long) grid[i][j] + (long) Math.min(solve(grid, i + 1, j), solve(grid, i, j + 1));
      return dp[i][j];
    }

  }

  public int minPathSum(int[][] grid) {
    if (grid == null) {
      return 0;
    }
    dp = new long[grid.length + 1][grid[0].length + 1];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        dp[i][j] = -1;
      }
    }
    return (int) solve(grid, 0, 0);
  }
}