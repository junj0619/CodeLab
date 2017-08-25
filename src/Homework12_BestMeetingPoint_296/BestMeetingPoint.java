//TLE 56 / 57 test cases passed.
class Solution {
    
    class Point {
        int row;
        int col;
        
        Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    
    public int min;
    public int rows;
    public int cols;
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    public int[][] dist = null;
    public boolean[][] visited = null;      
    public Deque<Point> queue = new ArrayDeque<>();
    
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        rows = grid.length;
        cols = grid[0].length;
        dist = new int[rows][cols];        
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {                   
                    bfs(grid, i, j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                               //Input: [[1,0,1,0,1]]
                               //Output:5
                               //Expected:4 
                    //reason without check grid[i][j] == 0 because they can meet at the 1 point. for this e.g they meet at [2,2]         
                    min = Math.min(min, dist[i][j]);
               
            }
        }
        return min == Integer.MAX_VALUE ? 1 : min ;
    }
    
    public void bfs(int[][] grid, int row, int col) {

        visited = new boolean[rows][cols];
        visited[row][col] = true;

        queue.offer(new Point(row, col));
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {

                Point curr = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int rowIndex = curr.row + dx[i];
                    int colIndex = curr.col + dy[i];

                    if (rowIndex >= 0 && rowIndex < rows
                            && colIndex >= 0 && colIndex < cols                           
                            && !visited[rowIndex][colIndex]) {                                               
                        dist[rowIndex][colIndex] += level;
                        visited[rowIndex][colIndex] = true;
                        queue.offer(new Point(rowIndex, colIndex));
                    }

                }
            }
            level++;
        }

    }
}
