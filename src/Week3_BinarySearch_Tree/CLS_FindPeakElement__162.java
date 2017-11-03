class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid + 1] > nums[mid])
                start = mid;
            else 
                end = mid;
        }
        
        return nums[start] > nums[end] ? start : end;
    }
}
