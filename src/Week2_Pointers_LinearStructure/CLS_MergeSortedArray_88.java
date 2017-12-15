class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || n == 0) return;
        
        int p1 = m - 1;
        int p2 = n - 1;
        int ptr = m + n - 1;
        
        while (p1 >= 0 && p2 >= 0) {            
            nums1[ptr--] = (nums1[p1] >= nums2[p2]) ? nums1[p1--] : nums2[p2--];            
        }
        
        while(p2 >= 0) {
            nums1[ptr--] = nums2[p2--];
        }
    }
}
