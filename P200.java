class Solution {
  private boolean[][] visited;

  public void dfs(char[][] grid, int i, int j) {
    if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || visited[i][j] == true || grid[i][j] == '0') {
      return;
    }

    visited[i][j] = true;
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i - 1, j);
    dfs(grid, i, j - 1);
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    visited = new boolean[grid.length][grid[0].length];
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1' && visited[i][j] == false) {
          dfs(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }
}
