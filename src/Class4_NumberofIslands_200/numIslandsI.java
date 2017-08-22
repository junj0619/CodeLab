class numIslandsI {
      class Point { //for bfs queue
            int x;
            int y;
            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    Deque<Point> queue = new ArrayDeque();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int rows;
    private static int cols;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }                  
            }            
        }        
        return count;        
    }
    
    public void bfs(char[][] grid, int row, int col) {                
        queue.offer(new Point(row, col));
        grid[row][col] = '0';

        while(!queue.isEmpty()) {
            Point curr = queue.poll();            
            for (int i = 0; i < 4; i++) {
                int rowIndex = curr.x + dx[i];
                int colIndex = curr.y + dy[i];
                if (rowIndex >= 0 && rowIndex < rows && colIndex >= 0 && colIndex < cols && grid[rowIndex][colIndex] == '1') {
                    queue.offer(new Point(rowIndex, colIndex));
                    grid[rowIndex][colIndex] = '0';
                }
            }
        }                
    }
    
    
}
