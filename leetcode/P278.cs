/* The isBadVersion API is defined in the parent class VersionControl.
      bool IsBadVersion(int version); */

public class Solution : VersionControl {
    public int FirstBadVersion(int n) {
        
        int start = 1;
        int end = n;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            bool isBad = IsBadVersion(mid);
            bool isBadPrev = IsBadVersion(mid-1);
            
            if (isBad == true && isBadPrev == false) {
                return mid;
            } else if (isBad == true) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}