public class Solution {

//Not In - Place
/*
*   1, 2, 3           7, 4, 1
*   4, 5, 6    ==>    8, 5, 2      put first row in last col
*   7, 8, 9           9, 6, 3       put second row in second last col
*                                    put third row in third last col
*/
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;        
        int[][] temp = new int[row][col];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                temp[j][col - 1 - i] = matrix[i][j];
            }
        }
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}
