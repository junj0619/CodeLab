class Solution {
//BackTracking 3
    int numTickets = 0;
    int usedTickets = 0;
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();        
        HashMap<String, List<String>> map = new HashMap<>();
        numTickets = tickets.length;
        
        for (String[] ticket : tickets) {                   //Step 1: Build Adjacency List
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new LinkedList<String>());            
            } 
            map.get(ticket[0]).add(ticket[1]);            
        }
        
        for (List<String> nei : map.values()) {  //Step 2: Sort neighbor list
            Collections.sort(nei);
        }
        
        res.add("JFK");
        dfs("JFK", map, res);   //Step 3: Traverse graph
        return res;
    }
    
    private void dfs(String key,  HashMap<String, List<String>> map, List<String> res) {
        List<String> nei = map.get(key);
        if (nei == null || nei.size() == 0) return;
        
        for (int i = 0; i < nei.size(); i++) {
            String stop = nei.get(i);
            res.add(stop);
            nei.remove(i);
            usedTickets++;
            dfs(stop, map, res);
            if (numTickets == usedTickets) {
                return;
            } else {                //Step 4: BackTracking
                res.remove(res.size() - 1);
                nei.add(i, stop);
                usedTickets--;
            }
        }
    }
    
}
