public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjacencyMap = new HashMap<>(); //Key: node, Value: neighbors
        HashMap<Integer, Integer> indegreeMap = new HashMap<>();  //Key: node, Value: in-degree value
        List<Integer> res = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        
        //Step 1: Inital Adjacency List and In-degree
        for(int num = 0; num < numCourses; num++) {
            adjacencyMap.put(num, new ArrayList<Integer>());
            indegreeMap.put(num, 0);
        }
        
        for(int[] edge: prerequisites) {
            adjacencyMap.get(edge[1]).add(edge[0]);
            indegreeMap.put(edge[0], indegreeMap.get(edge[0]) + 1);
        }
        
        //Step 2: BFS all nodes that indegree value equal 0 nodes
        for(int num = 0; num < numCourses; num++) {
            if(indegreeMap.get(num) == 0) {
                queue.offer(num);
                res.add(num);
            }
        }
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int num : adjacencyMap.get(curr)) {
                int value = indegreeMap.get(num) - 1;
                indegreeMap.put(num, value);
                if(value == 0) {
                    queue.offer(num);
                    res.add(num);
                }
            }
        }
        
        //Step 3: Generate result array. If numCourses == res.size means all courses can be take no circle courses.
        if(res.size() == numCourses) {
            int[] resArray = new int[res.size()];
            for(int i = 0; i < res.size(); i++) {
                resArray[i] = res.get(i);
            }
            return resArray;
        } else {
            return new int[0];
        }
        
        
    }
}
