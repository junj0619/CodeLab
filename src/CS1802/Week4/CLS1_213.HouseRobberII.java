class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) return 0;
        if (len == 1) return nums[0];
        
        int selected = rob1(nums, 0, len - 2);
        int unSelected = rob1(nums, 1, len - 1);
        return Math.max(selected, unSelected);
    }
    
    private int rob1(int[] nums, int start, int end) {             
        int[] dp = new int[end - start + 2];
        dp[0] = 0;        
        dp[1] = nums[start];        
        
        for (int i = 2; i < end - start + 2; i++) {
            dp[i] = Math.max((dp[i - 2] + nums[start + i - 1]), dp[i - 1]);
        }
        return dp[end - start + 1];
    }
}
