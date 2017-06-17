package Class2_TwoSum_1;

import java.util.HashMap;

/**
 * Created by junjin on 6/10/17.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] input = {3, 2, 4};
        int[] arr = twoSum(input, 6);
        for (int i : arr) {
            System.out.printf(i + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(); //Key: target-current, Value: Index
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                arr[0] = map.get(nums[i]);
                arr[1] = i;
                return arr;
            }
            map.put(target - nums[i], i);
        }
        return arr;
    }

}
