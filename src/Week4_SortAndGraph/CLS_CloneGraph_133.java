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
}
