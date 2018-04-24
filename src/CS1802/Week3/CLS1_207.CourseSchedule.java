class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacencyList = new List[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) { //Build Node
            adjacencyList[i] = new ArrayList<>();
        }
        
        for (int[] pair : prerequisites) {
            adjacencyList[pair[1]].add(pair[0]); //Build Edge
            indegree[pair[0]]++;                 //Build Indegree
        }
        
        for (int i = 0; i < numCourses; i++) { 
            if (indegree[i] == 0) {             //Find Start node(s) which have 0 indegree
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {              //Start traversal and update indegree
            int preCourse = queue.poll();
            for (int nextCourse : adjacencyList[preCourse]) {
                if (--indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
            count++;                            //Count how many courses have been take
        }
        
        return count == numCourses;
    }
}
