class Solution {
    //Input   : [1, 1, 1, 1, 3, 3]
    //Output  : [1, 1, 3, 1] missing assign value to slow pointer element in else if case.
    //Expected: [1, 1, 3, 3]
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        
        int slow = 0, fast = slow + 1;
        int len = nums.length;
        int count = 1;
        
        while (fast < len) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast++];                
                count = 1;
            } else if (nums[slow] == nums[fast] && count < 2) {
                nums[++slow] = nums[fast++];                               
                count++;
            } else {
                fast++;            
                count++;
            }
        }
        return slow + 1;        
    }
}
