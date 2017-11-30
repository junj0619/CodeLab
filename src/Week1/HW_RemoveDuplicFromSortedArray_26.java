class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int len = nums.length;
        int slow = 0, fast = slow;
        
        while (fast < len) {
            if (nums[slow] != nums[fast])                        
                nums[++slow] = nums[fast];
            
            fast++;                                       
        }
        
        return slow + 1;
    }    
    
}
