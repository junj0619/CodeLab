package Class1_PlusOne_66;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by junjin on 6/2/17.
 *
 * Input :{9,9,9}
 * Result:{1,0,0,0}
 *
 * Input :{0}
 * Result:{1}
 *
 * Input :{4,5,6}
 * Result:{4,5,7}
 *
 * Input :null
 * Result:null
 *
 * Input :{8,9,9}
 * Result:{9,0,0}
 *
 * Input :{9}
 * Result:{1,0}
 *
 * Time,Space Complexity: O(N),O(N) (use extra ArrayList to avoid array size issue.)
 *
 *
 * Accepted Solutions Runtime Distribution:
 * Runtime: 3ms, Beat 1.94% of Java Submission
 */
public class PlusOne {

    public static void main(String[] args) {

        int[] arr = {9, 9, 9};
        int[] result = plusOne(arr);
        for (int num : result) {
            System.out.printf(num + " ");
        }
    }

    private static int[] plusOne(int[] arr) {
        if (arr == null) return null;
        /* Using ArrayList because it is dynamic array to auto increase the size of array */
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        int carry = 0;

        /* Add number from end of array so that iterative array from end */
        for (int i = arr.length - 1; i >= 0; i--) {
            /*Only plus one when it is last element*/
            if (i == arr.length - 1) {
                sum = arr[i] + 1;
            } else {
                sum = carry + arr[i];
            }
            arr[i] = sum % 10;
            carry = sum / 10;
            list.add(arr[i]);
        }
        if (carry > 0) list.add(1);
        /* result in reverse order so reverse list back */
        Collections.reverse(list);

        /*Initial another int array for return purpose*/
        int[] returnArr = new int[list.size()];

        for (int i = 0; i < returnArr.length; i++) {
            returnArr[i] = list.get(i);
        }
        return returnArr;
    }

    private static int[] plusOneOptimzied(int[] arr) {
        int size = arr.length;

        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i]++;
                return arr;
            }
            arr[i] = 0;
        }

        int[] newArray = new int[size + 1];
        newArray[0] = 1;
        return newArray;
    }

}

