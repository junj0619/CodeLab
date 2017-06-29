/*
* Logic :
*    1) Find median from input array using quick select
*       1.1) will return median value
*       1.2) will sort input array in 3 parts [smaller, meidan, larger]. We need this to create index mapping
*    2) Generate Index mapping base on partially sorted result
*    3) Swap elements into right position
*
*    Index :       0   1   2   3   4   5
*    Small half:   M       S       S    
*    Large half:       L       L       M
*
* 
*  Input: [1,5,1,1,6,4]
* Output: [1,6,1,5,1,4]
*
*  Input: [6,13,5,4,5,2]
* Output: [5,6,4,13,2,5]
*
*  Input: [4,5,5,6]
* Output: [5,6,4,5]
*
*  Input:[1]
* Output:[1]
*
*  Input:[1,2]
* Output:[2,1]
*
*  Input:[1,2,1]
* Output:[1,2,1]
*
*  Time Complexity: findKthLargst: O(n) = n + n/2 + n/4 + n/8 + ..... = 2n
* Space Complexity: O(1) swap in place
**/


public class Solution {
    public void wiggleSort(int[] nums) {
    
      int len = nums.length;
      int median = findKthLargst(nums, 0, len - 1,  len / 2);
      
   
      int left = 0;
      int right = len - 1;
      int i = 0;
      
      while(i <= right) {
          if(nums[mappedIndex(i, len)] > median) {
              swap(nums, mappedIndex(i, len), mappedIndex(left, len));
              left++;
              i++;
          } else if (nums[mappedIndex(i, len)] < median) {
              swap(nums, mappedIndex(i, len), mappedIndex(right, len));
              right--;
          } else {
              i++;
          }
      }
    }
    
    
    
    public int mappedIndex(int index, int len) {
        return (1 + 2 * index) % (len | 1);
    }
    
    
    
    
    public int findKthLargst(int[] nums, int start, int end, int k) {
        int pivot = nums[end];
        int j = start - 1;
        
        for(int i = start; i < end; i++) {
            if(nums[i] < pivot) {
                swap(nums, i, ++j);
            }
        }
        
        swap(nums, ++j, end);
        
        if(j == k) {
            return nums[j];
        } else if (k > j) {
            return findKthLargst(nums, j + 1 , end, k);
        } else {
            return findKthLargst(nums, start , j - 1, k);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
}
