public class Solution {

//Not In - Place beats:63.18%
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
    
    
/*
*   1, 2, 3     1, 4, 7     7, 4, 1
*   4, 5, 6  => 2, 5, 8  => 8, 5, 2
*   7, 8, 9     3, 6, 9     9, 6, 3
*/

    public void rotateInPlace(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;        
               
        for(int i = 0; i < row; i++) {                           // i = 0                     i = 1             i = 2
            for(int j = i; j < col; j++) {  //!!!! j = i swap from [{0, 0}, {0, 1}, {0, 2}], [{1, 1}, {1, 2}], [{3, 3}]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;                
            }
        }      
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col / 2; j++) { //!!!! j < col / 2 swap font end elements until reach mid point
                int temp = matrix[i][j];                    
                matrix[i][j] = matrix[i][col - 1 - j];
                matrix[i][col - 1 - j] = temp;
            }
        }
    }  
}
