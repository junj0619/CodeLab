import java.io.*;
/*
*  Time Complexity: O(n+k) where n is the number of elements in input array and k is the range (max-min) of input.
*  Auxiliary Space: O(n+k)
*  Stable : Y (by scan element from end to start)
*
*/
class MyCode {
  public static void main (String[] args) {
    int[] nums = new int[] {3, 4, 2, 2 ,5 ,5, 3, 9, 7};
    for(int num : sort(nums)) {
      System.out.printf(num + ",");
    }
    
  }
  
  private static int[] sort(int[] nums) {
    
    int min = nums[0];
    int max = nums[0];
    
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] < min) min = nums[i];
        if (nums[i] > max) max = nums[i];            
    }
    
    int range = max - min + 1;
    int[] count = new int[range];
    int[] res = new int[nums.length];
    
    for (int num : nums) {
        count[num - min]++;      
    }
    
    for (int i = 1; i < range; i++) {
        count[i] += count[i - 1];
    }
    
    for (int i = nums.length - 1; i >= 0; i--) {      // <= will make sort stable, scan from end to start       
        res[--count[nums[i] - min]] = nums[i];
      
    }
    return res;    
  }  
  
}


