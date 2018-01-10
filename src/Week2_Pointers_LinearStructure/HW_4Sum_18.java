class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
/*
 * -2, -1, 0, 0, 1, 2   T = 0
 *  i         j  k  l
 *
 */
        Arrays.sort(nums);        
        int i = 0;
        int l = nums.length - 1;
        int k = l - 1;
        int j = k - 1;
        
        while (l >= 3) {
            k = l - 1;            
            while (k >= 2) {
                j = k - 1;
                i = 0;
                
                int value = target - nums[l] - nums[k];                
                while (i < j) {
                    int iPlusj = nums[i] + nums[j];
                    if (iPlusj == value) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        result.add(list);
                        
                        i++;
                        j--;                            
                        while (i < j && nums[i] == nums[i - 1]) i++;
                        while (i < j && nums[j] == nums[j + 1]) j--;
                    } else if (iPlusj < value) 
                        i++;
                    else
                        j--;                    
                }
                k--;
                while (k >= 2 && nums[k] == nums[k + 1]) k--;
            }
            l--;
            while (l >= 3 && nums[l] == nums[l + 1]) l--;
        }
        return result;
    }
}
