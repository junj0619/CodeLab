/***
*  Input : [0, -2, 3, 1], Target = 2
*  Output: 2   // [-2, 0, 1], [-2, 0, 3]
*  
*  Logic : Sort Input Array First, So we can use three pointers to solve this problem
*          [-2, |  0,  1,  3]     Pointer: cur move from 0 to (length - 2)
*            |  |  |       |               low = cur + 1  
*           cur | low      hi               hi = length - 1;
*
*          Looking for nums[hi] - nums[low] < Target - nums[cur]
*          If find it then means from hi to low there are (hi - low) combination satisfy the requirement.
*          Ex: nums[hi] - nums[low] < Target - nums[cur]
*                 nums[3] - nums[1] < 2 - nums[0] 
*                            3  - 0 < 2 - (-2) so there are 3 - 1 combinations statisfy the requirement for current.
*                                                     [-2 => (0, 3), (0, 1)]
*               then increase (low++) low to test some bigger low number.
*               If nums[hi] - nums[low] >= Target - nums[cur] means smaller combination should be on the left,
*               So decrease hi (hi--) to test some smaller hi number.
* 
*  Time Complexity: Sorting Array O(nlogn) + Scan arrays with 3 pointers O(n2) = O(n2)
* Space Complexity: O(1) only use 3 pointer3 + count and length variables
*           Beats : 86.49%
**/

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        
        int count = 0;
        int length = nums.length;
        Arrays.sort(nums);
        
        for(int cur = 0; cur < length - 2; cur++) {
            int remain = target - nums[cur];
            int low = cur + 1;
            int hi = length - 1;
            while (low < hi) {
                if(nums[low] + nums[hi] < remain) {
                    count += hi - low;
                    low++;
                } else {
                    hi--;
                }                                
            }            
        }
        return count;                
    }
}
