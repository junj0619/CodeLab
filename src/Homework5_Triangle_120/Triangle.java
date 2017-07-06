/**
* Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
* For example, given the following triangle
* [
*     [2],
*    [3,4],
*   [6,5,7],
*  [4,1,8,3]
* ]
* The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
* Note:
* Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*
*
* ====================================================
* Translate input to Solution Tree
*          2
*       /     \
*      3       4
*     /  \   /   \
*    6     5      7
*   /  \  /  \   /  \
*  4    1      8     3
* 
* so the conduction rule is min(Left, Right) + itself
* ===================================================
* 2
* 3, 4
* 6, 5, 7
* 4, 1, 8, 3
*
* Bottom-Up to fill DP array
* [                      ^
*  [ 11]                 |
*  [ 9, 10 ]             |
*  [ 7, 6, 10 ]          |
*  [ 4, 1, 8, 3 ]        |
* ]                      |
*
* Need to figure out how to use 1D DP array to store min path
**/

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
         
        int row = triangle.size();
        int col = triangle.get(row - 1).size(); //Get the last row col size
       
        
        int[][] dp = new int[col][row];
        
        for(int i = row - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                if(i == row - 1) {
                    dp[i][j] = triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }            
        }        
        return dp[0][0];
    }
}
