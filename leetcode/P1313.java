class Solution {
    public int[] decompressRLElist(int[] nums) {
        int size = 0;
        for (int i=0; i<nums.length; i+=2) {
            size += nums[i];
        }
        int[] result = new int[size];
        int k=0;
        int j=0;
        for (int i=1; i<nums.length; i+=2) {
            for (j=k; j<nums[i-1]+k; j++) {
                result[j] = nums[i];
            } 
            k = j;
        }
        return result;
    }
}