class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        List<Integer>[] adjacencyList = new List[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        
        //Step 1: build node
        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList<Integer>();
        }
        
        //Step 2: build edges and indegree
        for (int[] pair : prerequisites) {
            adjacencyList[pair[1]].add(pair[0]);
            indegree[pair[0]]++;
        }
        
        //Step 3: find start point (indegree = 0)
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        //Step 4: start travesal and eliminate the node
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            res[count++] = node;
            for (int nei : adjacencyList[node]) {
                if (--indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        
        return count == numCourses ? res : new int[0];
    }
}
