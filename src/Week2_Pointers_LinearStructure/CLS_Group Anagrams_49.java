class Solution {
//Apporach #1: Sort Each str then save in the HashMap
//Complexity Analysis
//Time Complexity: O(NK \log (K) )O(NKlog(K)), where NN is the length of strs, 
//                 and KK is the maximum length of a string in strs. 
//                 The outer loop has complexity O(N)O(N) as we iterate through each string. 
//                 Then, we sort each string in O(K \log K)O(KlogK) time.
//Space Complexity: O(N*K)O(N∗K), the total information content stored in ans.


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
}
