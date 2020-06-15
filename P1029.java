class Solution {
  private int[][] dp;
  
  private int util(int[][] costs, int pos, int countA, int countB) {
      if (pos == costs.length) return 0;
      
      if(dp[countA][countB] != -1) return dp[countA][countB];
      int option1=Integer.MAX_VALUE, option2=Integer.MAX_VALUE;
      if (countA > 0) {
          option1 = costs[pos][0] + util(costs, pos+1, countA-1, countB);
      }
      if (countB > 0) {
          option2 = costs[pos][1] + util(costs, pos+1, countA, countB-1);
      }
      dp[countA][countB] = Math.min(option1, option2);
      return Math.min(option1, option2);
  }
  
  public int twoCitySchedCost(int[][] costs) {
      
      dp = new int[(costs.length/2) + 1][(costs.length/2) + 1];
      for (int i=0; i<(costs.length/2) + 1; i++) {
          Arrays.fill(dp[i], -1);
      }
      return util(costs, 0, costs.length/2, costs.length/2);
  }
}