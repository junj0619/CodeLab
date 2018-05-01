class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        
        for (int curAmount = 1; curAmount <= amount; curAmount++) {
            memo[curAmount] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (curAmount - coin >= 0 && memo[curAmount - coin] != Integer.MAX_VALUE) {
                    memo[curAmount] = Math.min(memo[curAmount], memo[curAmount - coin] + 1);
                }
            }
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
}
