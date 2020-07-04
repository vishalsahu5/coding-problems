class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {

    int[] nums = new int[m + n];
    int i = 0, j = 0;
    int k = 0;
    while ((i < m) && (j < n)) {

      if (nums1[i] > nums2[j]) {
        nums[k] = nums2[j];
        k++;
        j++;
      } else {
        nums[k] = nums1[i];
        k++;
        i++;
      }
    }
    while (i < m) {
      nums[k] = nums1[i];
      k++;
      i++;
    }
    while (j < n) {
      nums[k] = nums2[j];
      k++;
      j++;
    }

    for (int index = 0; index < nums.length; index++) {
      // System.out.print(nums[index] + " ");
      nums1[index] = nums[index];
    }
    // nums1 = nums.clone();
  }
}