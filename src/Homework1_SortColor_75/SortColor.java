package Homework1_SortColor_75;

/**
 * Created by junjin on 6/6/17.
 * <p>
 * Input : {}
 * Output: {}
 * <p>
 * Input : {0}
 * Output: {0}
 * <p>
 * Input : {0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2}
 * OutPut: {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}
 * <p>
 * Input : {1, 1, 1, 0, 0, 0, 0, 2, 2, 2, 2, 2}
 * Output: {0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2}
 * <p>
 * Input : {2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0}
 * Output: {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2}
 *
 *
 * Time Complexity : O(N*LogN) QuickSort Average Running time
 * Space Complexity: O(1)
 *
 * Accepted Solutions Runtime Distribution
 * Runtime: 1 ms
 * Beats  : 5.70%
 */
public class SortColor {

    public static void main(String[] args) {
//        int[] arr = {0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2};
//        int[] arr = {1, 1, 1, 0, 0, 0, 0, 2, 2, 2, 2, 2};
        int[] arr = {2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0};
        /*           0,{2, 2, 2, 2, 2, 1, 1, 1, 0, 0, 2}
        *              {1, 1, 1, 0, 0} 2 {2, 2, 2, 2, 2}
        *               0,{1, 1, 0, 1}
        *                  0,{1, 1, 1}
        * */

        sortColors(arr);

        for (int num : arr) {
            System.out.printf(num + " ");
        }
    }

    public static void sortColors(int[] nums) {
        if (nums.length == 0) return;
        sortColor(nums, 0, nums.length - 1);
    }

    public static void sortColor(int[] arr, int start, int end) {
        if (start < end) {
            int position = partition(arr, start, end);
            sortColor(arr, start, position - 1);
            sortColor(arr, position + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = i + 1; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        arr[end] = arr[i + 1];
        arr[i + 1] = pivot;
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
