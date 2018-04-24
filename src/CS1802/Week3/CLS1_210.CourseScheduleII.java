class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) { 
        List<Integer> res = new ArrayList<>(numCourses);        
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
                
        while (!queue.isEmpty()) {              //Start traversal and update indegree
            int preCourse = queue.poll();
            res.add(preCourse);                 //Add course to the result
            for (int nextCourse : adjacencyList[preCourse]) {
                if (--indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);                  
                }
            }            
        }
        
        return res.size() == numCourses ? res.stream().mapToInt(i -> i).toArray() : new int[0];
    }
}
