class Solution {
//One pass 
    public int[] searchRange(int[] nums, int target) {
        int[] res = { Integer.MAX_VALUE, Integer.MIN_VALUE };
        helper(nums, target, res, 0, nums.length - 1);
        
        return res[0] > res[1] ? new int[] { -1, -1 } : res;        
    }
    
    private void helper(int[] nums, int target, int[] res, int start, int end) {
        if (start > end) return;
        
        int mid = (start + end) >> 1;
        
        if (nums[mid] > target) {
            helper(nums, target, res, start, mid - 1);
        } else if (nums[mid] < target) {
            helper(nums, target, res, mid + 1, end);
        } else {
            if (res[0] > mid) {
                res[0] = mid;
                helper(nums, target, res, start, mid - 1);
            }
            
            if (res[1] < mid) {
                res[1] = mid;
                helper(nums, target, res, mid + 1, end);
            }            
        }        
    }
}
