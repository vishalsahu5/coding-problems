class Solution {
  private int maxValue(int[] nums) {
    int maxVal = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      maxVal = Math.max(maxVal, nums[i]);
    }
    return maxVal;
  }

  public int maxSubArray(int[] nums) {
    int maxSum = 0;
    int currSum = 0;
    for (int i = 0; i < nums.length; i++) {
      currSum = Math.max(0, currSum + nums[i]);
      maxSum = Math.max(currSum, maxSum);
    }
    if (maxSum == 0) {
      boolean isAllNeg = true;
      for (int i = 0; i < nums.length; i++) {
        isAllNeg = nums[i] < 0 ? true : false;
      }
      if (isAllNeg) {
        return maxValue(nums);
      }
    }

    return maxSum;
  }
}