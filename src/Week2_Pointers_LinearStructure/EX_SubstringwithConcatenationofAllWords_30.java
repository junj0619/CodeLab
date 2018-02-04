class Solution {
//Approach #1: O(n^2)
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
                
        int m = words.length;
        int n = words[0].length();
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i <= s.length() - m * n; i++) {            
            HashMap<String, Integer> copy = new HashMap<>(map);            
            int k = i;
            int c = m;
            
            while (c > 0) {
                String str = s.substring(k, k + n);                
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }
                
                copy.put(str, copy.get(str) - 1);
                c--;                               
                k += n;
            }       
            
            if (c == 0)                 
                res.add(i);                                                
        }
        
        return res;
        
    }
}
