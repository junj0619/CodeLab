class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        
        int len = words1.length;
        HashMap<String, HashSet<String>> adjacencylist = new HashMap<>();
        Set<String> visited = new HashSet<>();
        
        for (String[] pair : pairs) {
            addToMap(adjacencylist, pair[0], pair[1]);
            addToMap(adjacencylist, pair[1], pair[0]);
        }
        
        for (int i = 0; i < len; i++) {
            if (words1[i].equals(words2[i])) 
                continue;
            
            if (!adjacencylist.containsKey(words1[i]))
                return false;

            if (!dfs(adjacencylist, new HashSet<String>(), words1[i], words2[i]))
                return false;                        
        }
        
        return true;        
    }
    
    private boolean dfs(HashMap<String, HashSet<String>> map, Set<String> visited, String from, String to) {                             
        if (map.get(from).contains(to)) return true;
        
        visited.add(from);
        for (String word : map.get(from)) {
            if (!visited.contains(word) && dfs(map, visited, word, to)) {
                return true;
            }
        }
        return false;
    }
    
    private void addToMap(HashMap<String, HashSet<String>> map, String key, String value) {
        if (!map.containsKey(key)) {
            HashSet<String> set = new HashSet<>();
            set.add(value);
            map.put(key, set);
        } else {
            map.get(key).add(value);
        }
    }
}
