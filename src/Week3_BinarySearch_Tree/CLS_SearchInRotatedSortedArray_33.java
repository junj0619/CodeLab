class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start < end - 1) {            
            mid = (start + end) >>> 1;
            
            if (nums[mid] > nums[end]) {
                if (target > nums[mid]) 
                    start = mid;
                else if (target < nums[mid]) {                    
                    if (target > nums[end])
                        end = mid;
                    else
                        start = mid;
                } else
                    return mid;
                
            } else {
                if (target < nums[mid]) 
                    end = mid;
                else if (target > nums[mid]) {
                    if (target > nums[end])
                        end = mid;
                    else
                        start = mid;
                } else
                    return mid;
            }            
        }
        
        if (target == nums[start]) 
            return start;
        else if (target == nums[end])
            return end;
        else
            return -1;        
    }
}
