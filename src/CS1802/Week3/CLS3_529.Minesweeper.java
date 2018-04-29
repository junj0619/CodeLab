class Solution {
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; //anti-clockwise 8 directions
    int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    int rows = 0;
    int cols = 0;
    public char[][] updateBoard(char[][] board, int[] click) {
        rows = board.length;
        cols = board[0].length;
        int x = click[0], y = click[1];    
    
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
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (!isOutOfBound(newX, newY) && board[newX][newY] == 'M') {
                mineCount++;
            }
        }
        
        if (mineCount == 0) {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (!isOutOfBound(newX, newY) && board[newX][newY] == 'E') {
                    dfs(board, newX, newY);
                }
            }
        } else {
            board[x][y] = (char)('0' + mineCount);
        }
    }
    
    private boolean isOutOfBound(int x, int y) {
        if (x < 0 || x > rows - 1 || y < 0 || y > cols - 1) {
            return true;
        } else {
            return false;
        }
    }
}
