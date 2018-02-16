class Solution {    
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int start = 0;
        int end = nums.length - 1;

        while (start < end - 1) {
            int mid = (start + end) >>> 1;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) { //mid is too small
                if (nums[mid] > nums[end]) //mid in left
                    start = mid;
                else { //mid in right
                    if (target <= nums[end])
                        start = mid;
                    else
                        end = mid;
                }
            } else { //mid is too large
                if (nums[mid] > nums[end]) { // mid in left
                    if (target >= nums[start])
                        end = mid;
                    else
                        start = mid;
                } else //mid in right
                    end = mid;
            }
        }
        
        if (nums[start] != target && nums[end] != target)
            return -1;
        return nums[start] == target ? start : end;
    }
    
    
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
