class Solution {
    class Point{
        int row;
        int col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public  int rows;
    public  int cols;

    public  int[] dx = {-1, 1, 0, 0};
    public  int[] dy = {0, 0, -1, 1};
    public  int[][] dist = null;
    public  boolean[][] visited = null;
    public  int numberOfBuildings = 0;    
    public  int[][] numofBuildings = null;
    
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int min = Integer.MAX_VALUE;
        rows = grid.length;
        cols = grid[0].length;
        dist = new int [rows][cols];
        numofBuildings = new int[rows][cols];
        numberOfBuildings = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] != 0)
                    dist[i][j] = Integer.MAX_VALUE;

                if (grid[i][j] == 1) {
                    numberOfBuildings++;
                    visited = new boolean[rows][cols];
                    bfs(grid, i, j);
                }

            }
         }

         for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(numberOfBuildings == numofBuildings[i][j]) {                   
                    min = Math.min(min, dist[i][j]);
                }
            }
         }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    public void bfs(int[][] grid, int row, int col) {
        int level = 1;
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(row, col));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point curr = queue.poll();
                visited[curr.row][curr.col] = true;
                for (int idx = 0; idx < 4; idx++) {
                    int rowIndex = curr.row + dx[idx];
                    int colIndex = curr.col + dy[idx];

                    if (rowIndex >= 0 && rowIndex < rows
                            && colIndex >= 0 && colIndex < cols
                            && grid[rowIndex][colIndex] == 0
                            && !visited[rowIndex][colIndex]) {
                        queue.offer(new Point(rowIndex, colIndex));
                        dist[rowIndex][colIndex] += level;
                        visited[rowIndex][colIndex] = true;
                        numofBuildings[rowIndex][colIndex]++;
                    }
                }
            }

            level++;
        }
    }
}
