public class Solution
{
  // private Dictionary<Tuple<int, int>, int> dp;
  int[,] dp;

  public int LongestCommonSubsequence(string text1, string text2)
  {
    // dp = new Dictionary<Tuple<int, int>, int>();
    dp = new int[text1.Length, text2.Length];
    for (int i = 0; i < text1.Length; i++)
    {
      for (int j = 0; j < text2.Length; j++)
      {
        dp[i, j] = -1;
      }
    }
    return util(text1, text2, 0, 0);
  }

  public int util(string text1, string text2, int pos1, int pos2)
  {
    if (pos1 == text1.Length || pos2 == text2.Length)
    {
      return 0;
    }
    if (dp[pos1, pos2] != -1) return dp[pos1, pos2];

    int option1 = 1 + util(text1, text2, pos1 + 1, pos2 + 1);
    int option2 = util(text1, text2, pos1, pos2 + 1);
    int option3 = util(text1, text2, pos1 + 1, pos2);
    if (text1[pos1] == text2[pos2])
    {
      return dp[pos1, pos2] = Math.Max(option1, Math.Max(option2, option3));
    }
    else
    {
      return dp[pos1, pos2] = Math.Max(option1 - 1, Math.Max(option2, option3));
    }
  }
}