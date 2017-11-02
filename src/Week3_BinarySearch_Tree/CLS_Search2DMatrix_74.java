class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int start = 0;
        int end = rows * cols - 1;
        
        while (start < end - 1) {
            int mid = start + (end - start) / 2;            
            int row = mid / cols;
            int col = mid % cols;
            
            if (matrix[row][col] > target) 
                end = mid;
            else if (matrix[row][col] < target)                
                start = mid;
            else
                return true;                                        
        }
        
        if (matrix[start / cols][start % cols] == target || matrix[end / cols][end % cols] == target)
            return true;
        else
            return false;        
    }
}
