class Solution {
//Two Pass O(n). Need to learn one pass solution.
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int len = height.length - 1;
        int curMax = height[0];
        int max[] = new int[height.length];
        int water = 0;
        
        //caculate max[] from left to right
        for (int i = 0; i <= len; i++) {
            curMax = Math.max(curMax, height[i]);            
            max[i] = curMax;
        }
        
        curMax = height[len];
        //caculate max[] from right to left
        for (int j = len; j >= 0; j--) {
            curMax = Math.max(curMax, height[j]);
            max[j] = Math.min(curMax, max[j]);
            water += max[j] - height[j];
        }
        
        return water;                                
    }
}
