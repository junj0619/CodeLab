class Solution {
//By Silding Window
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
}
