class Solution {
  private void dfs(int[][] image, int row, int col, int color, int newColor) {
      if (row >= image.length || row < 0 || col >= image[0].length || col < 0 || image[row][col] != color) {
          return;
      }
      
      image[row][col] = newColor;
      dfs(image, row+1, col, color, newColor);
      dfs(image, row, col+1, color, newColor);
      dfs(image, row-1, col, color, newColor);
      dfs(image, row, col-1, color, newColor);
  }
  
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      if (image[sr][sc] == newColor) return image;
      dfs(image, sr, sc, image[sr][sc], newColor);
      return image;
  }
}