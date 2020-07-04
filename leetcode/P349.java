class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int i = 0, j = 0;
    Set<Integer> resultSet = new HashSet<>();
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j]) {
        resultSet.add(nums1[i]);
        i++;
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      }
    }
    int[] result = new int[resultSet.size()];
    i = 0;
    for (int item : resultSet) {
      result[i++] = item;
    }
    return result;
  }
}