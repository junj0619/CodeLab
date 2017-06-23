package Homework3_FindMinimumInRotatedSortedArray_153;

/**
 * Created by junjin on 6/21/17.
 *
 *         /  |
 *        /   |
 *       /    |
 * _____/_____|__________
 *            |     /
 *            |    /
 *            |   /
 *            |  /
 */
public class FinaMininRotatedSortedArray {

    public static void main(String[] args) {
//        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
//        int[] arr = {9, 0, 1, 2, 3, 4, 5, 6, 7};

        int result = findMinimumin(arr);
        System.out.println(result);
    }

    public static int findMinimumin(int[] arr) {

        if (arr.length == 1) return arr[0];

        int start = 0;
        int end = arr.length - 1;

        while (start < end - 1) {
            int mid = (start + end) >>> 1;

            if (arr[mid] < arr[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return arr[start] < arr[end] ? arr[start] : arr[end];
    }
}
