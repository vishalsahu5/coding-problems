public class Solution
{
  public int MaximalSquare(char[][] matrix)
  {
    int rows = matrix.Length, cols = rows > 0 ? matrix[0].Length : 0;
    int[][] dp = new int[rows][];
    for (int i = 0; i < rows; i++) dp[i] = new int[cols];
    int maxsqlen = 0;
    for (int i = 0; i < rows; i++)
    {
      for (int j = 0; j < cols; j++)
      {
        if (i == 0 || j == 0)
        {
          dp[i][j] = matrix[i][j] - '0';
          maxsqlen = Math.Max(maxsqlen, dp[i][j]);
          continue;
        }
        if (matrix[i][j] == '1')
        {
          dp[i][j] = Math.Min(dp[i - 1][j - 1], Math.Min(dp[i - 1][j], dp[i][j - 1])) + 1;
          maxsqlen = Math.Max(maxsqlen, dp[i][j]);
        }
        else
        {
          dp[i][j] = 0;
        }
      }
    }
    return maxsqlen * maxsqlen;
  }
}