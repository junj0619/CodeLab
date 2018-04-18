class Solution {
    public int[] searchRange(int[] nums, int target) {        
        
        int[] res = new int[] {-1, -1};
        int begin = searchFirstSmaller(nums, target);
        int end = searchFirstSmaller(nums, target + 1);
        
        if (begin < end) {
            return new int[] {begin + 1, end};
        }
        return res;        
    }
    
    private int searchFirstSmaller(int[] nums, int target) {
        if (nums.length == 0 || target <= nums[0]) return -1;
        
        int start = 0, end = nums.length - 1;        
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (nums[mid] >= target) 
                end = mid - 1;
            else
                start = mid;
        }
        return start;
    }
}
