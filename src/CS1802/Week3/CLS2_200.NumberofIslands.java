class Solution {
    private static int rows = 0;
    private static int cols = 0;  
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j); //Make all related 1 to 0
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row > rows - 1 || col < 0 || col > cols - 1 || grid[row][col] == '0')
            return;
        
        grid[row][col] = '0';
        for (int i = 0; i < 4; i++) {
            int rowNum = row + dx[i];
            int colNum = col + dy[i];
            dfs(grid, rowNum, colNum);
        }                                
    }
}
