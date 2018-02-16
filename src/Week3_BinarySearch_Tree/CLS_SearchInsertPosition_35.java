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
        int start = 0;
        int end = nums.length - 1;
        
        if (target <= nums[0]) 
            return 0;        
        else if (target > nums[end])
            return end + 1;
        else {
            while (start < end - 1) {
                int mid = (start + end) >>> 1;
                
                if (nums[mid] == target) 
                    return mid;
                else if (nums[mid] > target) 
                    end = mid;
                else
                    start = mid;                                
            }            
        }
        return end;
    }
}
