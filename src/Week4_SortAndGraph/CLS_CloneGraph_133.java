/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
/** Approach #1: DFS **/
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>(); //Orig Node, New Node
        return clone(node, map);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        
        //1. Create node and put into map   
        map.put(node, new UndirectedGraphNode(node.label));
        
        //2. Create all edges starting from current copied
        for (UndirectedGraphNode nei : node.neighbors) {            
            UndirectedGraphNode neiNode = map.get(nei);            
            if (neiNode == null) {
                neiNode = clone(nei, map);
            }
            map.get(node).neighbors.add(neiNode);            
        }
        return map.get(node);        
    }
    
    
    
/** Approach #2: BFS **/    
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        return clone(node);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        
        Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.pollFirst();
            UndirectedGraphNode copy = map.get(cur);
            
            for (UndirectedGraphNode nei : cur.neighbors) {
                if (map.get(nei) == null) {
                    queue.offerLast(nei);
                    map.put(nei, new UndirectedGraphNode(nei.label));
                }
                copy.neighbors.add(map.get(nei));
            }            
        }
        return map.get(node);
    }
}
