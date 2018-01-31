class Solution {
//Approach #1: By Silding Window O(2n)
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        
        char[] chars = s.toCharArray();
        Set<Character> charSet = new HashSet();        
        int start = 0, end = 0, ans = 0, n = s.length();
        
        while (start < n && end < n) {
            if (!charSet.contains(chars[end])) {
                charSet.add(chars[end++]);
                ans = Math.max(ans, end - start);
            } else {
                charSet.remove(chars[start++]);
            }            
        }        
        return ans;        
    }
    
////Approach #2: By Silding Window O(n) 
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int lo = 0, hi = 0, len = s.length(), res = 0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>(); //Key: char, Value: index        
        
        while (hi < len) {
            if (map.containsKey(chars[hi])) {                
                lo = Math.max(lo, map.get(chars[hi]));   //Need max because some case like "abba"                        
            } 
            
            map.put(chars[hi], hi + 1);  //to avoid low equals map.index and get next start index without mannual increase                              
            res = Math.max(res, hi - lo + 1);
            hi++;
        }
        
        return res;
    }
}


