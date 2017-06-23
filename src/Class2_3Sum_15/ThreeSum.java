package Class2_3Sum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by junjin on 6/20/17.
 * <p>
 * Input : {1, 2, -1, -1, 0, -4, 1}
 * Output: [{-1, 0, 1},{-1, -1, 2}]
 */
public class ThreeSum {

    public static void main(String[] args) {

        int[] arr = {1, 2, -1, -1, 0, -4, 1};

        List<List<Integer>> list = threeSum(arr);

        for (List<Integer> curr : list) {
            System.out.println("{" + curr.get(0) + ", " + curr.get(1) + ", " + curr.get(2) + "}");
        }
    }

    public static List<List<Integer>> threeSum(int[] arr) {
        if (arr.length < 3) return null;

        List<List<Integer>> res = new ArrayList<>();

        //Step 1: Sort array
        Arrays.sort(arr);
        // {-4, -1, -1, 0, 1, 1, 2};

        //Step 2: Iterate arr
        for (int i = 0; i < arr.length - 2; i++) {

            //Not working if put arr[i] == arr[i+1] ?? why
            //Because it will decrease the available range
            //For example: {-4, -1, -1 .....
            //When for loop meet first -1 it will execute continue;
            //Then reach second -1 so that we lose two -1 {-1,-1,x} combination
            //So we should check against to previous not to next

            if (i > 0 && arr[i] == arr[i - 1]) continue; //skip duplicate

            //Step 3: Calculate remaining value for current element;
            int result = 0 - arr[i];

            //Step 4: Define low , high pointers
            int low = i + 1;
            int high = arr.length - 1;

            while (low < high) {
                int value = arr[low] + arr[high];
                if (value == result) {

                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[low]);
                    list.add(arr[high]);
                    res.add(list);

                    low++;
                    high--;

                    while (low < high && arr[low] == arr[low - 1]) low++; //skip duplicate
                    while (low < high && arr[high] == arr[high + 1]) high--; //skip duplicate

                } else if (value < result) {
                    low++;
                } else {
                    high--;
                }

            }
        }
        return res;
    }

}
