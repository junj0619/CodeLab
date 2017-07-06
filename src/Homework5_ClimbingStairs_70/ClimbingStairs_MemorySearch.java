/**
* You are climbing a stair case. It takes n steps to reach to the top.
* Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
* Note: Given n will be a positive integer.
* 
*
*  Ex:  n = 5 
*  
*                       [8] (0, 5)
*                          /      \
*                 [5] (1, 5)   [3] (2,  5)
*                    /      \           
*             [3] (2, 5)  [2] (3, 5) 
*                /      \     
*         [2] (3, 5)  [1] (4, 5) 
*            /      \
*    [1] (4, 5) [1] (5, 5)
*        / 
* [1] (5, 5) 
*
*  Index :  0, 1, 2, 3, 4, 5
*  memo = [ 8, 5, 3, 2, 1, 1 ]
*    Left <=================== Right
*
* Time Complexity: O(n) = size of recursion  
* Space Complexity: O(n) = memo array O(n) + depth of recursion O(n) 
**/

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];                
        return climb_Stairs(0, n, memo);
    }
    
    public int climb_Stairs(int i, int n, int[] memo){
        if(i > n) {
            return 0;
        } 
        
        if(i == n) {
            return 1;
        } 
        
        if(memo[i] > 0) {
            return memo[i];
        }
        
       return memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);                
    }
}
