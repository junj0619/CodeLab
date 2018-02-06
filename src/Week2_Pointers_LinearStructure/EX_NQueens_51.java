class Solution {
//Backtracking
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) return res;
        
        helper(res, new int[n], 0);
        return res;
    }
    
    private void helper(List<List<String>> res, int[] queens, int pos) {//queens[] means where to put current row queen.
        if (pos == queens.length) {                                     //eg. [2, 4, 1, 3] queens[0] = 2 => Row:0 queen is placed in Col:2 
            addToResult(res, queens);                                   //pos means current row to scan
            return;
        }
        
        for (int i = 0; i < queens.length; i++) {
            queens[pos] = i;
            if (isValid(queens, pos)) {
                helper(res, queens, pos + 1);
            }
        }        
    }
    
    private boolean isValid(int[] queens, int pos) {
        
        for (int i = 0; i < pos; i++) {   // **only check i up to pos
            if (queens[pos] == queens[i]) // queens are in the same cols. eg:[0, 0, 0, 0], [0, 2, 0, 0]
                return false;            
            if (Math.abs(queens[pos] - queens[i]) == Math.abs(i - pos)) //queens are in the same diagonal. eg:[0, 1, 0, 0]       
                return false;                                           //                                 or [0, 2, 1, 0]
        }        
        return true;
    }
    
    private void addToResult(List<List<String>> res, int[] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {  
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {               
                if (queens[i] == j)
                    sb.append("Q");
                else
                    sb.append(".");                
            }
            list.add(sb.toString());                                    
        }
        res.add(list);
    }
    
    
}
