class Solution {
    
  public void sortColors(int[] nums) {
      int n = nums.length;
      int start=0, end = n-1;
      // find first 2 from start
      while(start < n && nums[start] == 0) start++;
      // find first 0 from end
      while(end >= 0 && nums[end] == 2) end--;
      int i = start;
      
      
      while(start < end && i <= end){
          if(nums[i] == 0){
              swap(nums[i], nums[start]);
              start++;
              i++;
          }else if(nums[i] == 1){
              i++;
          }else{
              swap(nums[i], nums[end]);
              end--;
          }
      }
  }
}