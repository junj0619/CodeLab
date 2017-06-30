/*
 *
*
*
* Beats : 22.19%
* Runtime: 50 ms
*
**/

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
 
        int n = matrix.length * (matrix[0].length);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(minHeap.isEmpty()){
                    minHeap.offer(matrix[i][j]);
                }
                else if(matrix[i][j] >= minHeap.peek()) {
                    minHeap.offer(matrix[i][j]);
                }
            }
        }
        
        for(int i = 1; i < k; i++) {
            minHeap.poll();
        }
        
        return minHeap.peek();
    }
}
