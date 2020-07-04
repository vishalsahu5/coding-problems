class Solution {
    
  private boolean[][] visited;
  private int[][] dp;
  private int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
  
  private int util(int[][] grid, int x, int y) {
      visited[x][y] = true; 
      int val = 0;
      for (int i=0; i<dirs.length; i++) {
          int new_x = x + dirs[i][0], new_y = y + dirs[i][1];
          if (new_x < grid.length && new_y < grid[0].length && new_x >= 0 && new_y >= 0 && !visited[new_x][new_y] && grid[new_x][new_y] != 0) {
              val = Math.max(val, util(grid, new_x, new_y));
          }
      }
      visited[x][y] = false;
      return val + grid[x][y];
  }
  
  public int getMaximumGold(int[][] grid) {
      if (grid == null) return 0;
      
      int result = 0;
      for (int p = 0; p < grid.length; p++) {
          for (int q = 0; q < grid[0].length; q++) {
              if (grid[p][q] == 0) continue;
              visited = new boolean[grid.length][grid[0].length];
              result = Math.max(result, util(grid, p, q));
          }
      }
      return result;
  }
}