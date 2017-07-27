public class Solution {
    public boolean validWordSquare(List<String> words) {
        
        int size = words.size();
        
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < words.get(row).length(); col++) {                
                //  has element at [i][j]                        && has element at [j][i]         &&      martrix[i][j] <> martrix[j][i]
                //  a b c <-- at[0][2] check [2][0] exist or not    b a l l                   
                //  b                                               a s e e
                //  ?                                               l e t ?
                //                                                  l e p <-- at [3][2] check [2][3] exist or not
                if (col >= size || words.get(col).length() <= row || words.get(row).charAt(col) != words.get(col).charAt(row)) {
                    return false;
                }                
            }                        
        }
        
        return true;
        
    }
}
