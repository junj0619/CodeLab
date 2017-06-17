package Class2_MergeSortedArray_88;

/**
 * Created by junjin on 6/11/17.
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class MergeSortedArray {

    public void merg(int[] nums1, int[] nums2, int m, int n) {
        int last = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[last--] = nums1[i--];
            else
                nums1[last--] = nums2[j--];
        }
        /*No need to consider nums1 array rest of records if nums2 is empty.
          Because nums2 array all elements are placed into right position.
          So reset of elements in nums1 are in the right postion.
        */

        /*If second array is not empty
          Means first array all elements already moved in the right postion
          Then append into first array from end*/
        while (j >= 0) {
            nums1[last--] = nums2[j--];
        }
    }

}
