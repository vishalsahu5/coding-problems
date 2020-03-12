class Solution {
    // private HashMap<Pair<Integer, Integer>, Integer> dp;
    private long[][] dp;
    
    private long solve (int x, int n, int charsCopied) {
        if (x == n) {
            return 1;
        }
        if (x > n || x + charsCopied > n) {
            return Integer.MAX_VALUE;
        }
        if (x == 1) {
            return 1 + solve(x+1, n, 1);
        } else {
            if (dp[x][charsCopied] == 0) {
                long ans = 1 + Math.min(solve(x+charsCopied, n, charsCopied), 1 + solve(x+x, n, x));
                dp[x][charsCopied] = ans;
                return ans;
            } else {
                return dp[x][charsCopied];
            }
        }
    }
    
    public int minSteps (int n) {
        // dp = new HashMap<Pair<Integer, Integer>, Integer>();
        if (n == 1) return 0;
        dp = new long[1000][1000];
        return (int)solve(1, n, 1);
    }
}