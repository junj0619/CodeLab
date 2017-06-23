package Homework3_FindPeakElement_162;

/**
 * Created by junjin on 6/21/17.
 */
public class FindPeakElement {

    public static void main(String[] args) {
//        int[] arr = {1, 6, 5, 4, 3, 2, 1};  //return 1
        int[] arr = {1, 2, 3, 4, 6, 5, 1}; // return 4 Fail! => return 3
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};    //return 6
//       int[] arr = {7, 6, 5, 4, 3, 2, 1};    //return 0
        System.out.println("Index of peak element : " + findPeakElement(arr));
    }

    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end - 1) {
            int mid = (start + end) >>> 1;
//            if (nums[mid] < nums[end]) {   <--- Fail to pass test case 2
//                start = mid;
//            } else {
//                end = mid;
//            }

            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }
}
