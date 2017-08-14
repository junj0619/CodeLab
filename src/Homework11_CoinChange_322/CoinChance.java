public class Solution {
    public int coinChange(int[] coins, int amount) {        
        if(amount == 0) return 0;
        int[] res = new int[amount + 1];
        return helper(coins, amount, res);
    }
    
    public int helper(int[] coins, int remain, int[] memo) {
        if(remain == 0) {
            return 0;
        }
        
        if(remain < 0) {
            return -1;
        }
        
        if(memo[remain] != 0) {
            return memo[remain];
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int coin : coins) {  
            if(coin > remain) continue;
            
            int res = helper(coins, remain - coin, memo);
            if(res != -1) {
                min = Math.min(res + 1, min);
            }        
        }
        memo[remain] = (min == Integer.MAX_VALUE)? -1 : min;   //[2] 1 return -1
        return memo[remain];
    }
    
}
