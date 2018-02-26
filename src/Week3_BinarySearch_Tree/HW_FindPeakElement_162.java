class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end - 1) {
            int mid = (start + end) >>> 1;            
            if (nums[mid] > nums[mid + 1])
                end = mid;
            else 
                start = mid;
        }            
        return nums[start] > nums[end] ? start : end;
    }
}
