public class Solution {
    public int minPathSum(int[][] grid) {
                
        int row = grid.length;
        int col = grid[0].length;
        
        if(col == 1 && row == 1) return grid[0][0];
                
        int[][] dp = new int[row + 1][col + 1];
        
        for(int i = 0; i < row + 1; i++) {  //Init right col
            dp[i][col] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < col + 1; i++) { //Init bottom row
            dp[row][i] = Integer.MAX_VALUE;
        }
        
        dp[row][col - 1] = 0;        
                
        for(int i = row - 1; i >= 0; i--) {
            for(int j = col - 1; j >= 0; j--) {                
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}
