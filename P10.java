class Solution {
  private int[][] dp;

  private boolean util(String s, String p) {
    if (p.length() == 0) {
      return s.length() == 0;
    }
    if (dp[s.length()][p.length()] != -1) {
      return dp[s.length()][p.length()] == 1 ? true : false;
    }

    boolean firstMatch = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
    boolean result = false;
    if (p.length() >= 2 && p.charAt(1) == '*') {
      result = util(s, p.substring(2)) || firstMatch && util(s.substring(1), p);
    } else {
      result = firstMatch && util(s.substring(1), p.substring(1));
    }
    dp[s.length()][p.length()] = result == true ? 1 : 0;
    return result;
  }

  public boolean isMatch(String s, String p) {
    dp = new int[s.length() + 1][p.length() + 1];
    for (int i = 0; i < s.length() + 1; i++) {
      Arrays.fill(dp[i], -1);
    }
    return util(s, p);
  }
}