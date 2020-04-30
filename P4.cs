public class Solution {
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.Length > nums2.Length) return FindMedianSortedArrays(nums2, nums1);
        
        int start = 0;
        int end = nums1.Length;
        
        while (start <= end) {
            int partitionX = (start + end)/2;
            int partitionY = ((nums1.Length + nums2.Length + 1)/2) - partitionX;
            int maxLeftX, maxLeftY, minRightX, minRightY;
            
            maxLeftX = partitionX == 0 ? Int32.MinValue : nums1[partitionX-1];
            minRightX = partitionX == nums1.Length ? Int32.MaxValue : nums1[partitionX];
            maxLeftY = partitionY == 0 ? Int32.MinValue : nums2[partitionY-1];
            minRightY = partitionY == nums2.Length ? Int32.MaxValue : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((nums1.Length + nums2.Length) % 2 == 0){
                    return (double)(Math.Max(maxLeftX, maxLeftY) + Math.Min(minRightX, minRightY))/2.0;
                } else {
                    return (double)Math.Max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX >= minRightY) {
                end = partitionX - 1;
            } else {
                start = partitionX + 1;
            }
        }
        return -1;
    }
}