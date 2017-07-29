public class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = heights.length;
        int maxArea = 0;
        
        stack.push(-1); //Inital bottom        
        
        for (int i = 0; i < len; i++) {
            int num = heights[i];
            //avoid ArrayIndexOutOfBounds ==> heights[-1]
            while (stack.peek() != -1 && num <= heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            
            stack.push(i);
        }
        
        while (stack.peek() != -1) {            
            maxArea = Math.max(maxArea, heights[stack.pop()] * (len - stack.peek() - 1));
        }
        
       return maxArea; 
    }
}
