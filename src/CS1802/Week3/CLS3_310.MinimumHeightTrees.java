class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {        
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        //Step 1: Build Adjacency List
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<Integer>());
        }
        
        for (int[] edge : edges) {         //It is undirected graph so create edge for both nodes
            adj.get(edge[0]).add(edge[1]);  
            adj.get(edge[1]).add(edge[0]);
        }
                
        //Step 2: Find leaf nodes means the node only has one neighbor
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        //Step 3: Remove leaf one by one
        int numOfNodes = n;
        while (numOfNodes > 2) {
            numOfNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {                
                int nei = adj.get(leaf).iterator().next();
                adj.get(nei).remove(leaf);
                if (adj.get(nei).size() == 1) {
                    newLeaves.add(nei);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
