/*
*
* Example 1:
* Input: [0,1,2,4,5,7]
* Output: ["0->2","4->5","7"]
*
* Example 2:
* Input: [0,2,3,4,6,8,9]
* Output: ["0","2->4","6","8->9"]
*
*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        
        int len = nums.length;
        int i = 0, j = i + 1;
        
        while (j < len) {            
            if (nums[j] - nums[j - 1] != 1) {
                list.add(getString(i, j, nums));
                i = j;
            }
            j++;                            
        }
        
        list.add(getString(i, j, nums));        
        return list;
    }
    
    private String getString(int i, int j, int[] nums) {
        if (nums[i] == nums[j - 1])
            return Integer.toString(nums[i]);
        else
            return nums[i] + "->" + nums[j - 1];
    }
}
