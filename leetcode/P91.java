class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            dp[i] = -1;
        }
        return util(s, dp, 0);
    }
    
    private int util(String s, int[] dp, int pos) {
        if (pos != s.length() && s.charAt(pos) == '0') return 0;
        if (pos == s.length() - 1 || pos == s.length()) {
            return 1;
        }
        
        if (dp[pos] != -1) {
            return dp[pos];
        }
        int singleDigit = Integer.valueOf(s.charAt(pos) - '0');
        int doubleDigit = Integer.valueOf(s.substring(pos, pos+2));
        int option1 = 0, option2 = 0;
        option1 = util(s, dp, pos+1);
        if (doubleDigit <= 26 && doubleDigit > 0) {
            option2 = util(s, dp, pos+2);
        }
        dp[pos] = option1 + option2;
        return option1+option2;
    }
}