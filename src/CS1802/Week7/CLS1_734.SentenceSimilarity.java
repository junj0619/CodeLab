class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {        
        if (pairs == null || words1.length != words2.length) return false;        
        
        int len = words1.length;
        HashMap<String, Set<String>> map = new HashMap<>();
        
        for (String[] pair : pairs) {
            addToMap(map, pair[0], pair[1]);
            addToMap(map, pair[1], pair[0]);           
        }
        
        for (int i = 0; i < len; i++) {
            if (words1[i].equals(words2[i]))
                continue;
            
            Set set = map.get(words1[i]);
            if (set == null || !set.contains(words2[i])) 
                return false;
        }
        
        return true;        
    }
    
    private void addToMap(HashMap<String, Set<String>> map, String key, String val){
        if (!map.containsKey(key)) {
            Set<String> set = new HashSet<>();
            set.add(val);
            map.put(key, set);
        } else {            
            map.get(key).add(val);
        }        
    }
}
