class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        int low = 0, hi = nums.length - 1, cur = 0;
        
        while (cur <= hi) {  // Caution use '<=' inside of '<'. Test Case: [1,0]
            if (nums[cur] == 0) 
                swap(nums, cur++, low++);                            
            else if (nums[cur] == 1) 
                cur++;
            else
                swap(nums, cur, hi--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        if (nums[i] == nums[j]) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
