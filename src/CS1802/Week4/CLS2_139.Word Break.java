/*
* Cut given string in two parts. 
* If we know first part is composition of wordDict then we just need to check second part is the word from dict.
* dp[0] means empty string
* dp[i] = true means from 0 to i positon is compostion of wordDict. Otherwise not a compostion.
* Time Complexity: O(n ^ 2) we calculate each position dp value and try any [0 - j) && [j - i) combinations in iteration.
*                  If we know [0 - j) is composition of wordDict then just need to check [j - i) is in the wordDict
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}
