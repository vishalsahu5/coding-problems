class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    int[] right = new int[nums.length];
    for (int i=0; i < result.length; i++) {
      result[i] = 1;
      right[i] = 1;
    }

    // Start from the left
    for (int i = 1; i < result.length; i++) {
      result[i] = result[i-1] * nums[i-1];
    }
    
    // Now do this from the right

    for (int i = result.length - 2; i >= 0 ; i--) {
      right[i] = right[i+1] * nums[i+1];
      result[i] = result[i] * right[i];
    }
    return result;
  }
}
// 1 2 3 4
// 1 1 8 6