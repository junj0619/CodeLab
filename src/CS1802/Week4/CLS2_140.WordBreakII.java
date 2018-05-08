class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet<>();
        HashMap<String, List<String>> memo = new HashMap<>();
        
        for (String word : wordDict) {
            set.add(word);
        }
        
        return helper(s, set, memo);
    }
    
    private List<String> helper(String s, Set<String> set, HashMap<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }                
        
        List<String> wordlist = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i + 1);
            if (set.contains(prefix)) {                     
                if (i == s.length() - 1) {
                    wordlist.add(prefix);
                } else {
                    List<String> words = helper(s.substring(i + 1), set, memo);
                    for (String word : words) {                        
                        wordlist.add(prefix + " " + word);
                    }                     
                }                
            }
        }
        
        memo.put(s, wordlist);
        return wordlist;
    }
}
