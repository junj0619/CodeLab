class Solution {
/*
* Height: 1 8 6 2 5 4 8 3 7
* Index : 0 1 2 3 4 5 6 7 8
*
* Max Water = 7(Index = 1) * 7(Index = 8) = 49
* O(n) Two Pointers
*/
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;        
        while (left < right) {            
            int water = Math.min(height[left], height[right]) * (right - left); 
            maxWater = Math.max(water, maxWater);
            
            if (height[left] > height[right]) right--;
            else left++;        
        }
        return maxWater;
    }
}
