package Class3_SearchInsertPosition_35;

/**
 * Created by junjin on 6/15/17.
 * <p>
 * Input : [1,3,4,5,6,7] target=2
 * Output: 2
 * IDX: 0,1,2,3,4,5  mid = 2
 *     [1,3,4,5,6,7] => 4 > 2 => end = mid = 2  start=0,end=2
 *     [1,3,4]      mid = 1 => 3 > 2 => end = mid = 1 start = 0, end = 1
 *     (start < end - 1) = 0 < 1 - 1 => false, start = 0, end = 1
 *     Return end as Inserted Position
 *
 * Input : [1,3,4,5,6,7] target=8
 * Output: 6
 *
 * Input : [1,3,4,5,6,7] target=-1
 * Output: 0
 *
 * Input : [1,3,4,5,6,7] target=3
 * Output: 1
 *
 * Input : [1,3,4,5,6,7] target=7
 * Output: 5
 *
 * Time Complexity : O(logN) Base on Binary Search
 * Space Complexity: O(1)
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7};

        System.out.println("Result:" + findIndex(arr, 2));
    }


    public static int findIndex(int[] arr, int num) {
        /*Corner Case
        * if num > last element of array then return length;
        * if num < first element of array then return 0;
        * */

        if (num < arr[0]) return 0;
        if (num > arr[arr.length - 1]) return arr.length;

        int start = 0;
        int end = arr.length - 1;
        /* Binary Search Template , avoid infinity loop */
        while (start < end - 1) {
            int mid = (start + end) >>> 1; // avoid overflow
            if (num == arr[mid]) {
                return mid;
            } else if (num < arr[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return end;
    }
}
