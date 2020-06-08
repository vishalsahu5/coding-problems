class Solution {
  private int[][] dp;

  public int util(int amount, int[] coins, int i) {
    if (amount == 0)
      return 1;
    if (amount < 0 || i == coins.length)
      return 0;
    if (dp[amount][i] != -1)
      return dp[amount][i];
    int result = util(amount - coins[i], coins, i) + util(amount, coins, i + 1);
    dp[amount][i] = result;
    return result;
  }

  public int change(int amount, int[] coins) {
    dp = new int[amount + 1][coins.length + 1];
    for (int i = 0; i < amount + 1; i++) {
      Arrays.fill(dp[i], -1);
    }
    return util(amount, coins, 0);
  }
}