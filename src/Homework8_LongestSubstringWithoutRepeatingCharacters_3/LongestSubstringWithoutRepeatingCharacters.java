public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int slow = 0;
        int fast = 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        
        while (fast < len && slow < len) {
            char ch = s.charAt(fast);
            if(set.contains(ch)) {
                set.remove(s.charAt(slow));
                slow++;
            } else {
                set.add(ch);
                fast++;
                
                res = Math.max(res, fast - slow);
            }                      
        }         
        return res;                
    }
}
