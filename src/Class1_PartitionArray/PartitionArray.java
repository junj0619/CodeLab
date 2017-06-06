package Class1_PartitionArray;

/**
 * Created by junjin on 6/2/17.
 *
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 *
 * Example
 * If nums = [3,2,2,1] and k=2, a valid answer is 1.
 *
 *
 * Input : {7,2,5,1,2,9,8,6,4} and k=4
 * Return: 3
 *
 * Input : {3,2,2,1} and k=2
 * Return: 1 (Why result not equal to 2 since there are duplicated 2 in the array?)
 *            Because question ask for move smaller element to the left so only 1 is moved to left.
 *            Then Index=1
 *
 * Input : null
 * Return: -1
 *
 * Input : {3,2,2,1} and k=5 (have to confirm can input K not in the array
 * Return: -1
 *
 * Input : {3,2,2,1} and k=3
 * Return: 3
 */
public class PartitionArray {
    public static void main(String args[]) {

        int[] arr = {7, 2, 5, 1, 2, 9, 8, 6, 4};
        int index = partition(arr, 0);

        System.out.println("Index: " + index);
    }

    public static int partition(int[] arr, int num) {
        if(arr==null) return -1;

        int slow = -1;
        int fast = 0;

        while (fast <= arr.length - 1) {
            if (arr[fast] < num) {
                slow++;
                /*Since Question only ask for correct slot index
                * So call swap function is extra cost
                * */
                swap(arr, fast, slow);
            }
            fast++;
        }

        return slow + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
