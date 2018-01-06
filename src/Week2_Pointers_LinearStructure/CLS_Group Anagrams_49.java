class Solution {
/*
* Apporach #1: Sort Each str then save in the HashMap
* Complexity Analysis
* Time Complexity: O(NKlog(K)), where N is the length of strs, 
*                 and K is the maximum length of a string in strs. 
*                 The outer loop has complexity O(N) as we iterate through each string. 
*                 Then, we sort each string in O(KlogK) time.
* Space Complexity: O(N*K), the total information content stored in ans.
*/

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            String key = sortString(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
         
        return new ArrayList<>(map.values());
    }
    
    private String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);        
    }
    
/*
* Approach #2:
* Convert each string character to ASCII and save the count, then the string delimited with '#' characters.
* For example, abbccc will be #1#2#3#0#0#0...#0 where there are 26 entries total. 
* Then use this value as key in the Hashmap
* 
* Complexity Analysis
* Time Complexity: O(N * K), where N is the length of strs, 
*                  and K is the maximum length of a string in strs. 
                   Counting each string is linear in the size of the string, and we count every string.
* Space Complexity: O(N*K), the total information content stored in ans.
*/
    
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();            
            int[] count = new int[26];
            StringBuilder sb = new StringBuilder();
            String key;
            
            for (char ch : chars) 
                count[ch - 'a'] += 1; 
                        
            for (int ct : count) 
                sb.append(ct).append('#');
            
            key = sb.toString();
            if (map.containsKey(key))
                map.get(key).add(str);
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }                        
        }
        
        return new ArrayList(map.values());
    }
}
