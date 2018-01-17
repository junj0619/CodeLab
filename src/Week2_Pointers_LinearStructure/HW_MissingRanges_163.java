class Solution {
/*
* [0, 1, 3, 50, 75] 0 - 99
* next = 0 
* 0 = 0 next = 1
* 1 = 1 next = 2
* [2] next = 3 + 1 = 4
* [4->49] next = 51
* [51->74] next = 76
* 76 < 99 [76->99]
* ans: [2, 4->49, 51->74, 76->99]
* 
* Corner case:
* Input: [2147483647] lower = 0, upper = 2147483647
*
* Output  : ["0->2147483646","-2147483648->2147483647"]
* Expected: ["0->2147483646"]
*
*/
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        
        int len = nums.length;
        int next = lower;
        
        for (int i = 0; i < len; i++) {
            if (nums[i] < next)   //not with in the range
                continue;    
            
            if (nums[i] == next && next < Integer.MAX_VALUE) {
                next++;
                continue;
            }
            
            if (next < Integer.MAX_VALUE) {                
                res.add(getRange(next, nums[i] - 1));   
                next = nums[i] + 1;
            }
            
            if (nums[i] == Integer.MAX_VALUE) //For corner case Integer.MAX_VALUE
                return res;
        }
                
        if (next <= upper)                        
            res.add(getRange(next, upper)); 
        
        return res;
    }
    
    private String getRange(int m, int n) {
        if (m == n)
            return String.valueOf(m);
        else
            return String.format("%d->%d", m, n);        
    }
}
