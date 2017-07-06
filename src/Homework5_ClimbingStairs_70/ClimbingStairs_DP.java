/**
*
* One can reach Ith step in one of the two ways:
* 1) Taking a single step from (i-1)th step
* 2) Taking a step of 2 from (i-2)th step
*
* So conduction rule: dp[i] = dp[i - 1] + dp[i - 2];
*
* Time complexity : O(n) Single loop upto n.
* Space complexity : O(n). Dp array of size n is used.
**/


public class ClimbingStairs_DP {
    public int climbStairs(int n) {
        
        if(n == 1) return 1;        
        
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}
