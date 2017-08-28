class Solution {
    class Point {
        int row;
        int col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;                
        }       
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int rows = 0;
    int cols = 0;
    Deque<Point> pacificQueue = new ArrayDeque<>();
    Deque<Point> atlanticQueue = new ArrayDeque<>();
    
    boolean[][] pacificVisited = null;
    boolean[][] atlanticVisited = null;
    
    List<int[]> res = new ArrayList<>();
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        
        rows = matrix.length;
        cols = matrix[0].length;
        
        pacificVisited = new boolean[rows][cols];
        atlanticVisited = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {             
            pacificQueue.offer(new Point(i, 0));
            atlanticQueue.offer(new Point(i, cols - 1));
            pacificVisited[i][0] = true;
            atlanticVisited[i][cols - 1] = true;
        }
        
        for (int j = 0; j < cols; j++) {            
            pacificQueue.offer(new Point(0, j));
            atlanticQueue.offer(new Point(rows - 1, j));
            pacificVisited[0][j] = true;
            atlanticVisited[rows - 1][j] = true;
        }
        
        bfs(matrix, pacificQueue, pacificVisited);
        bfs(matrix, atlanticQueue, atlanticVisited);
        
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++) {
                if (pacificVisited[row][col] && atlanticVisited[row][col]) {
                    res.add(new int[]{row, col});                    
                }                
            }
        }
        
        return res;
    }
    
    public void bfs(int[][] matrix, Deque<Point> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int rowIndex = curr.row + dx[i];
                int colIndex = curr.col + dy[i];
            
                if (rowIndex < 0 || rowIndex >= rows
                    || colIndex < 0 || colIndex >= cols
                    || matrix[curr.row][curr.col] > matrix[rowIndex][colIndex] 
                    || visited[rowIndex][colIndex])
                    continue;
                
                visited[rowIndex][colIndex] = true;                
                queue.offer(new Point(rowIndex, colIndex));
            }
            
        }
    }
}
