public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Step 1: Build adjacency list in HashMap
        //       And build degree hashmap
        HashMap<Integer, List<Integer>> adjacencyMap = new HashMap<>(); //Key: node, value: neighbor
        HashMap<Integer, Integer> indegree = new HashMap<>(); //Key:node, value: in-degree value
        List<Integer> res = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
                
        //inital adjacency list and in-degree 
        for(int i = 0; i < numCourses; i++) {
            adjacencyMap.put(i, new ArrayList<Integer>());
            indegree.put(i, 0);
        }
        
        //build adjacency list and update in-degree value
        //[[1,0], [2,0], [3,2]] ==> [0: [1,2]], [2: [3]]
        //In-degree: [0:0], [1:1], [2:1], [3:1]
        for(int[] edge : prerequisites) {            
            adjacencyMap.get(edge[1]).add(edge[0]);            
            indegree.put(edge[0], indegree.get(edge[0]) + 1);
        }
                    
        //Step 2:bfs adjacency list from in-degree = 0 and update in-degree value to -1 for each node
        for(int i = 0; i < numCourses; i++) {
            if(indegree.get(i) == 0) {
                queue.offer(i);
                res.add(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();            
            List<Integer> adjacencyList = adjacencyMap.get(curr);
            
            for(Integer node : adjacencyList) {
                int value = indegree.get(node) - 1;
                indegree.put(node, value);
                if(value == 0) {
                    queue.offer(node);
                    res.add(node);
                }
            }
        }
        
        //Step 3:return in-degree == 0 result (means those courses can be finished)        
        return res.size() == numCourses;
    }
}
