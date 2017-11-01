class Solution {
/**
* Here are few examples.
* [1,3,5,6], 5 → 2
* [1,3,5,6], 2 → 1
* [1,3,5,6], 7 → 4
* [1,3,5,6], 0 → 0
*
*
* Key point: search the next larger number of given target
*/
    public int searchInsert(int[] nums, int target) {
        if (nums == null) return 0;
        
        int len = nums.length;
        if (target < nums[0]) 
            return 0;
        else if (target > nums[len - 1]) 
            return len;
        else {
            int start = 0;
            int end = len - 1;
            
            while (start < end - 1) {
                int mid = (start + end) >>> 1;
                if (target > nums[mid]) 
                    start = mid;
                else
                    end = mid;
            }
            
           return (target > nums[start]) ? end : start;
        }
    }
}
