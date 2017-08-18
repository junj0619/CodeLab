
class Solution {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        
        //replace multiple * with one *
        //e.g: a***b***c => a*b*c
        int writeIndex = 0;
        boolean isFirst = true;
        
        for (int i = 0; i < pattern.length; i++) {
           if (pattern[i] == '*') {
               if (isFirst) {
                   pattern[writeIndex++] = pattern[i];
                   isFirst = false;
               }
           } else {
               pattern[writeIndex++] = pattern[i];
               isFirst = true;
           }
        }
        
        boolean dp[][] = new boolean[str.length + 1][writeIndex + 1];
        
        dp[0][0] = true;
        //if first char in pattern is '*' then * match anything in string
        if (writeIndex > 0 && pattern[0] == '*') {
            dp[0][1] = true;
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                if (pattern[j - 1] == '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        }
        
        return dp[str.length][writeIndex];        
    }
}
