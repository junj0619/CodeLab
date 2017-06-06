package Homework1_RemoveDuplicatesfromSortedArrayII_80;

/**
 * Created by junjin on 6/5/17.
 *
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5,
 * with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 *
 *
 *
 * Input : []
 * Output: []
 *
 * Input : [1,1,2,2,3,3]
 * Output: 6
 *
 * Input : [1,1,1,2,2,3]
 * Output: 5
 *
 * Input : [1,2,3,4,5]
 * Output: 5
 *
 * Input : [1,1,1,1,3,3]
 * Output: 4
 *
 * Time complexity : O(N)
 * Space complexity: O(1)
 *
 * Accepted Solutions Runtime Distribution
 * Runtime: 2 ms
 * Beats  :6.53%
 */
public class RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0;
        int count = 1;
        for (int fast = slow + 1; fast < nums.length; fast++) {
            if (nums[fast] == nums[slow] && count < 2) {
                count++;
                slow++;
                nums[slow] = nums[fast];
            } else if (nums[fast] != nums[slow]) {
                count = 1;
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
