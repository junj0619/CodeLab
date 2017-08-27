// need to revise only beat 3.33%! =m=?

class Solution {
    class Point {
        int row;
        int col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }    
    
    public int rows;
    public int cols;
    public boolean[][] visited;
    public int[][] dist;
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    public Deque<Point> queue = new ArrayDeque<>();
    public int INF = Integer.MAX_VALUE;
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || (rooms.length == 1 && rooms[0].length == 1)) return;

        rows = rooms.length;
        cols = rooms[0].length;
        dist = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    visited = new boolean[rows][cols];
                    bfs(rooms, i, j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == INF) {
                    int value = dist[i][j];
                    rooms[i][j] = value == 0 ? INF : value;
                }
            }
        }                        
    }
    
    public void bfs(int[][]grid, int row, int col) {       
        visited[row][col] = true;
        queue.offer(new Point(row, col));

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point curr = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int rowIndex = curr.row + dx[k];
                    int colIndex = curr.col + dy[k];

                    if (rowIndex >= 0 && rowIndex < rows
                            && colIndex >= 0 && colIndex < cols
                            && !visited[rowIndex][colIndex]
                            && grid[rowIndex][colIndex] == INF) {

                        if (dist[rowIndex][colIndex] == 0)
                            dist[rowIndex][colIndex] += level;
                        else
                            dist[rowIndex][colIndex] = Math.min(dist[rowIndex][colIndex], level);

                        visited[rowIndex][colIndex] = true;
                        queue.offer(new Point(rowIndex, colIndex));
                    }
                }
            }
            level++;
        }
    }
    
}


//Revise version beats:60.27%
//Reason : no need to keep visited array and calculated min value for each INF node
//We initiate breadth-first search (BFS) from all gates at the same time.
//BFS guarantees that we search all rooms of distance d before searching rooms of distance d + 1, 
//the distance to an empty room must be the shortest.
class Solution {
    class Point {
        int row;
        int col;
        
        Point(int row, int col) {
            this.row = row;
            this.col = col;        
        }
    }
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        int rows = rooms.length;
        int cols = rooms[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int INF = Integer.MAX_VALUE;        
        Deque<Point> queue = new ArrayDeque<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) 
                    queue.offer(new Point(i, j));            
            }
        }
        
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            int level = 1;
            for (int i = 0; i < 4; i++) {
                int rowIndex = curr.row + dx[i];
                int colIndex = curr.col + dy[i];
                
                if (rowIndex < 0 || rowIndex >= rows || colIndex < 0 || colIndex >= cols || rooms[rowIndex][colIndex] != INF) {
                    continue;
                }
                queue.offer(new Point(rowIndex, colIndex));
                rooms[rowIndex][colIndex] = rooms[curr.row][curr.col] + 1;
            }                
        }                
    }
}
