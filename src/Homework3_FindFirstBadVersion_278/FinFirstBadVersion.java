package Homework3_FindFirstBadVersion_278;

/**
 * Created by junjin on 6/21/17.
 */
public class FinFirstBadVersion {

    public int findMin(int n) {
        int start = 1;
        int end = n;

        while (start < end - 1) {
            int mid = (start + end) >>> 1;

            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return isBadVersion(start) ? start : end;
    }


    public int finMin2(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int mid = (start + end) >>> 1;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return  start;
    }


    public boolean isBadVersion(int versionId) {
        return true;
    }
}
