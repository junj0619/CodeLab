class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end - 1) {
            int mid = (start + end) >>> 1;
            
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            else {
                if (nums[mid] > nums[end]) //on the left
                    start = mid;
                else                       //on the right
                    end = mid;                
            }            
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}
