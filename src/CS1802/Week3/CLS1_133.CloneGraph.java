/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return clone(node, map);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        map.put(node, new UndirectedGraphNode(node.label));
        
        for (UndirectedGraphNode nei : node.neighbors) {
            UndirectedGraphNode copy = map.get(nei);
            if (copy == null) {
                copy = clone(nei, map);
            }
            map.get(node).neighbors.add(copy);
        }
        return map.get(node);
    }
}
