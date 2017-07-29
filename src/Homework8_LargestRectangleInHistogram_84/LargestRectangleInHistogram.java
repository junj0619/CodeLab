public class Solution {
    public int largestRectangleArea(int[] heights) {
      //Time Limit Exceeded 
      //Time Complexity: O(n2)  
      //Space Complexity: O(1)
        int maxArea = 0;
        int len = heights.length;
        for (int i = 0; i < len; i++) {
            int minValue = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                minValue = Math.min(minValue, heights[j]);
                maxArea = Math.max(maxArea, minValue * (j - i + 1));
            }
        }
        
        return maxArea;
    }
}
