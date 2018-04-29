class Solution {
    int rows = 0;
    int cols = 0;
    int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1}; //up, down, left, right, top-left, bottom-left, bottom-right, bottom-up
    int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    public char[][] updateBoard(char[][] board, int[] click) {
        rows = board.length;
        cols = board[0].length;
        int x = click[0];
        int y = click[1];
        
        dfs(board, x, y);
        return board;       
    }
    
    private void dfs(char[][] board, int x, int y) {                 
         if (board[x][y] == 'M') {
             board[x][y] = 'X';
             return;
         }
        
        int mineCount = 0;
        for (int i = 0; i < 8; i++) {
            int newX = dx[i] + x;
            int newY = dy[i] + y;  
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && board[newX][newY] == 'M') {                    
                mineCount++;
            }
        }
        
        if (mineCount == 0) {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {                                
                int newX = dx[i] + x;
                int newY = dy[i] + y; 
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && board[newX][newY] == 'E') {                
                    dfs(board, newX, newY);
                }                
            }            
        } else {
            board[x][y] = (char)('0' + mineCount);
        }                
    }
}
