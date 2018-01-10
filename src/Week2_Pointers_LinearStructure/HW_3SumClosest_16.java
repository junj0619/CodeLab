class Solution {
//O(n2)
    public int threeSumClosest(int[] nums, int target) {        
        int start = 0;
        int end = nums.length - 1, mid = end - 1;
        int ans = nums[end] + nums[mid] + nums[start];
        Arrays.sort(nums);     
        while (end >= 2) {
            start = 0;
            mid = end - 1;                                               
            while (start < mid) {
                int sum = nums[end] + nums[mid] + nums[start];                
                
                if (sum == target)
                    return sum;                
                else {
                    if (Math.abs(sum - target) < Math.abs(ans - target))
                        ans = sum;
                    else {
                       if (sum > target) {
                           mid--;
                           while (start < mid && nums[mid] == nums[mid + 1]) mid--;
                       }
                       else { 
                           start++;                                            
                           while (start < mid && nums[start] == nums[start - 1]) start++;
                       }
                    }
                }                                    
            }
            end--;            
            while (end > 1 && nums[end] == nums[end + 1]) end--;
        }
        return ans;                                             
    }
}
