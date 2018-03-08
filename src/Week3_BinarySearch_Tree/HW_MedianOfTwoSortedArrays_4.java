class Solution {
    /*
    * Time Complexity: O(log(Min(num1, num2))), Space Complexity : O(1)
    *        0 1 2 3 4 5
    *          L1   R1  
    *nums1: [3,5, | 8,9]
    *nums2: [1,2,7, | 10,11,12]
    *            L2   R2  
    *nums3:  1,2,3,5,7, || 8,9,10,11,12
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        
        int len = nums1.length + nums2.length;
        int cutL = 0;
        int cutR = nums1.length;
        int cut1 = 0, cut2 = 0;
        
        while (cut1 <= nums1.length) {
            cut1 = (cutL + cutR) >>> 1;
            cut2 = len / 2 - cut1;
            
            double L1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1]; 
            double R2 = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];
             
            if (L1 > R2)
                cutR = cut1 - 1;
            else if (L2 > R1)
                cutL = cut1 + 1;
            else {
                if (len % 2 == 0)                    
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                else
                    return Math.min(R1, R2);
            }                                        
        }
        return -1;
        
    }
}
