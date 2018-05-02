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
}
