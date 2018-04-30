class Solution {
    //BackTracking #4
    List<List<String>> res = null;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        int[] queens = new int[n];
        int curRow = 0;
        
        dfs(curRow, queens);
        return res;            
    }
    
    private void dfs(int curRow, int[] queens) {
        if (curRow == queens.length) {
            addToResult(queens);
            return;
        }
        
        for (int i = 0; i < queens.length; i++) {
            queens[curRow] = i;            //BackTracking <==
            if (isValid(queens, curRow)) {
                dfs(curRow + 1, queens);
            }
        }
    }
    
    private boolean isValid(int[] queens, int curRow) {
        for (int i = 0; i < curRow; i++) {
            if (queens[i] == queens[curRow]) {   //Check in same column
                return false;
            }
            
            if (Math.abs(i - curRow) == Math.abs(queens[i] - queens[curRow])) { // check in same diagonal
                return false;
            }
        }
        return true;        
    }
    
    private void addToResult(int[] queens) {
        int n = queens.length;
        List<String> curSolution = new ArrayList<>();
        for (int i = 0; i < n; i++) {    
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {                
                if (queens[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            curSolution.add(sb.toString());
        }
        res.add(curSolution);
    }
}
