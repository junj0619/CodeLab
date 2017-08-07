public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // A: [1,2,3] B: [4,5,6,7] return 5
        // A: [1,2,3] B: [4,5,6] return (3+4)/2 = 3.5
        // A: []      B: [1,2,3] return 2
        // A: [1,2,3] B: [] return 2
        // A: []      B: [] return null
        
        int len = nums1.length + nums2.length;
        int k = len / 2;
        double median;
        
        if (len % 2 == 0) {
            median = (findKthInSortedArrays(nums1, nums2, k + 1, 0, 0) + findKthInSortedArrays(nums1, nums2, k, 0, 0)) * 0.5;
        } else {
            median = findKthInSortedArrays(nums1, nums2, k + 1, 0, 0);
        }
        return median;
    }
    
    public int findKthInSortedArrays(int[] nums1, int[] nums2, int k, int i, int j) {
        //If i exceed len of nums1 then the kth element in nums2
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        //If j exceed len of nums2 then the kth element in nums1
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }        
        //If k == 1 return min(nums1[i],nums2[j])
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        
        //Why is k/2 in each arrays?
        //We are searching the kth element in merg arrays so that we just need to find k/2 in each of them.         
        //Step 1: Compare k/2 element between nums1 and nums2
        //Step 2: If nums1[k/2] < nums2[k/2] means from nums1[0] to nums1[k/2] are in the first Kth elements
        //        Then increase i; Compare nums1[k/2] + 1 to nums1[end]  vs nums2
        //        Else do the same thing to nums2
        
        int m1 = k / 2 + i - 1;
        int m2 = k / 2 + j - 1;
        
        int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
        int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;
        
        if (mid1 < mid2) {
            // why k - k/2 as new k? 
            //Ex: First time:Try to find the 5th smallest element but find 2 elements in the 5 smallest of element
            //    Second just time need to find 5 - 2 smallest element so then use k - k/2
            return findKthInSortedArrays(nums1, nums2, k - k / 2, m1 + 1, j);
        } else {
            return findKthInSortedArrays(nums1, nums2, k - k / 2, i, m2 + 1);
        }
        
    }
}
