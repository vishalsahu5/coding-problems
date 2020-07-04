class Solution {
  public int peakIndexInMountainArray(int[] A) {
    int start = 0, end = A.length - 1;
    while (start < end - 1) {
      int mid = start + (end - start) / 2;
      if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
        return mid;
      } else if (A[mid] < A[mid + 1]) {
        start = mid;
      } else if (A[mid] < A[mid - 1]) {
        end = mid;
      }
    }
    if (A[start] < A[end]) {
      return A[end];
    }
    return A[start];
  }
}