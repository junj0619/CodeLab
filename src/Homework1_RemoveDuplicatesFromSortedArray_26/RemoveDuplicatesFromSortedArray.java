package Homework1_RemoveDuplicatesFromSortedArray_26;

/**
 * Created by junjin on 6/5/17.
 *
 * Input : []
 * OutPut: 0
 *
 * Input :[1,1,2]
 * Output:2
 *
 * Input :[1,1,2,3,3]
 * Output:3
 *
 * Input :[1,2,3]
 * Output:3
 *
 * Input :[1,2,3,3,3,3,3]
 * Output:3
 *
 * Time complexity : O(N)
 * Space complexity: O(1)
 *
 * Accepted Solutions Runtime Distribution
 * Run Time: 16ms. Beats:32.95%
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        int len = removeDuplicates(arr);
        System.out.println("Len:" + len);
        for (int num : arr) {
            System.out.printf(num + " ");
        }

    }

    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        int slow = 0;
        for (int fast = slow + 1; fast < arr.length; fast++) {
            if (arr[slow] != arr[fast]) {
                slow++;
                arr[slow] = arr[fast];
            }
        }
        //Index started from 0
        return slow + 1;
    }

}
