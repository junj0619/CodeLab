class Solution {
    public String minWindow(String s, String t) {
        int len = s.length();
        int total = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            total++;
        }
        
        for (int low = 0, hi = 0; hi < len; hi++) {
            
            char hiChar = s.charAt(hi);
            if (map.containsKey(hiChar)) {
                int count = map.get(hiChar) - 1;
                map.put(hiChar, count);
                
                if (count >= 0) {
                    total--;
                }                
            }
            
            while (total == 0) {
                
                if (hi - low < minLen) {
                    start = low;
                    minLen = hi - low;
                }
                
                char lowChar = s.charAt(low);
                
                if (map.containsKey(lowChar)) {
                    int count = map.get(lowChar) + 1;
                    map.put(lowChar, count);
                    
                    if (count > 0) {
                        total++;
                    }                    
                }    
                low++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen + 1);
    }
}
