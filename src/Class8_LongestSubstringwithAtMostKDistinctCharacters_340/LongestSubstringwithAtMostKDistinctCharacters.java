public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
       
        int fast = 0;
        int slow = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>(); //Key: char, value: frequency
        
        for (fast = 0; fast < s.length(); fast++) {
           char ch = s.charAt(fast);
           map.put(ch, map.getOrDefault(ch, 0) + 1);
           
           while (map.size() > k) {
             char c = s.charAt(slow);
             int freq = map.get(c);
               
             if (freq == 1) {
                 map.remove(c);
             } else {
                 map.put(c, freq - 1);
             }      
               
             slow++;
           }            
          len = Math.max(len, fast - slow + 1);        
        }
        return len;
    }
}
