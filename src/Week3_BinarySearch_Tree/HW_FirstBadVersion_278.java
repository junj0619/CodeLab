/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        
        while (start < end - 1) {
            int mid = (start + end) >>> 1;
            
            if (isBadVersion(mid))
                end = mid;
            else
                start = mid;                        
        }
        
        return isBadVersion(start) ? start : end;
    }
}
