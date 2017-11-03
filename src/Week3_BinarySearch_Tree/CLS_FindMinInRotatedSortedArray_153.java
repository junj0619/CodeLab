class Solution {
/*
* (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
*
* Possible Input:
*     1) 0, 1, 2, 4, 5, 6, 7       ==>  /
*     2) 7, 6, 5, 4, 2, 1, 0       ==>  \
*     3) 4, 5, 6, 7, 0, 1, 2       ==>  /\
*
* Mid point locations:                                                                         ......
*     1) at increasing trend means nums[start] < nums[mid] < nums[end]                        /      \
*     2) at decreasing trend means nums[start] > nums[mid] > nums[end]                       / <= mid \
*     3) at curve but located at pre-peak means nums[start] < nums[mid] > nums[end]  ==>    /          \
*     4) at curve but located at dips mean nums[start] > nums[mid] < nums[end]  ==>
*                                                                                    \          /
*                                                                                     \ <= mid /
*                                                                                      ........     
*/
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] > nums[start] && nums[mid] < nums[end])
                end = mid;
            else if (nums[mid] < nums[start] && nums[mid] > nums[end])
                start = mid;
            else if (nums[mid] > nums[start] && nums[mid] > nums[end]) 
                start = mid;
            else 
                end = mid;
        }
        
        return nums[start] > nums[end] ? nums[end] : nums[start];
    }
}
