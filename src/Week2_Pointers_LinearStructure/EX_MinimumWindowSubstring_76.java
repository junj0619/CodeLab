class Solution {
    public String minWindow(String s, String t) {
        
        int[] map = new int[128];
        int count = t.length(), from = 0, minLen = Integer.MAX_VALUE;
        //Step 1: create mapping to t string
        for (Character ch : t.toCharArray()) {
            map[ch]++;
        }
        
        for (int lo = 0, hi = 0; hi < s.length(); hi++) {
            char ch = s.charAt(hi);
            if (map[ch] > 0)  //Step 2: find the match character. decrease count;
                count--;
            map[ch]--;        //Step 3: decrease map count for current character;
            
            while (count == 0) {        //Step 4: count == 0 means fully matching t string. Then find smaller window size
                if (hi - lo < minLen) { //Step 5: update result if find smaller window
                    from = lo;
                    minLen = hi - lo;
                }
                               
                char lowCh = s.charAt(lo);
                map[lowCh]++;          //Step 6: increase lo to find smaller matching window
                
                if (map[lowCh] > 0) {  //find match character that is going to be remove from window. then increase count
                    count++;           //increament count for remove character and update map value. 
                }
                
                lo++;
            }                        
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(from, from + minLen + 1);                
    }
}
