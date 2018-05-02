class Solution {
//Top-Down
    public int rob(int[] nums) {
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        return helper(nums.length, nums, memo);
    }
    
    private int helper(int pos, int[] nums, int[] memo) {
        if (pos < 1) {
            return 0;
        }
        
        if (memo[pos] != -1) {
            return memo[pos];
        }
        
        int selected = helper(pos - 2, nums, memo) + nums[pos - 1];
        int unselected = helper(pos - 1, nums, memo);
        memo[pos] = Math.max(selected, unselected);
        return memo[pos];
    }
    
    //Bottom-up
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] r = new int[n + 1];  //rob 
        int[] nr = new int[n + 1]; //not rob
        
        r[1] = nums[0];
        nr[1] = 0;
        
        for (int i = 2; i <= n; i++) {
            r[i] = nr[i - 1] + nums[i - 1];
            nr[i] = Math.max(r[i - 1], nr[i - 1]);
        }
        
        return Math.max(r[n], nr[n]);
    }

}
