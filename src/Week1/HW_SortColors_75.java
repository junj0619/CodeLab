class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        
        int left = 0, pointer = 0;
        int right = nums.length - 1;
        
        while (pointer <= right) {
            if (nums[pointer] == 2) 
                swap(nums, pointer, right--);                                            
            else if (nums[pointer] == 0) 
                swap(nums, pointer++, left++);                                            
            else
                pointer++;                        
        }        
    }
    
    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
