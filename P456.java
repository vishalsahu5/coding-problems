class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int[] minVal = new int[nums.length];
        
        minVal[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            minVal[i] = Math.min(minVal[i-1], nums[i]);
        }
        
        for (int j=1; j <= nums.length-2; j++) {
            for (int k=j+1; k<=nums.length-1; k++) {
                if (nums[k] < nums[j] && minVal[j-1] < nums[k]) {
                    return true;
                }
            }
        }
        return false;
    }
}