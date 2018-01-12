class Solution {
    //Approach #1 4Pointers base on 3Sum idea
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
    
    // Approach #2: LC Solution break down 4sum -> 3sum -> 2sum throw all possible anwser into result;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length < 4) return result;   
        
        Arrays.sort(nums);
        
        int len = nums.length;
        int max = nums[len - 1];
        int min = nums[0];
                        
        if (4 * max < target || 4 * min > target) return result;
            
        for (int i = 0; i < len - 3; i++) {
            min = nums[i];
            if (i > 0 && min == nums[i - 1]) 
                continue;      
            if (4 * min > target) 
                break;
            if (min + 3 * max < target)
                continue;
            if (4 * min == target) {
                if (i + 2 < len && min == nums[i + 3])
                    result.add(Arrays.asList(min, min, min, min));
                break;
            }
            threeSumForFourSum(nums, i + 1, len - 1, min, target - min, result);
                                    
        }        
        return result;
    }
    
    private void threeSumForFourSum(int[] nums, int low, int high, int firstEle, int target, List<List<Integer>> result) {
        if (low + 1 >= high) return;
        
        int max = nums[high];
        int min = nums[low];
        
        if (3 * max < target || 3 * min > target) return;
        
        for (int i = low; i < high; i++) {
            min = nums[i];
            if (i > low && min == nums[i - 1] ) 
                continue;
            if (3 * min > target)
                break;
            if (min + 2 * max < target) 
                continue;
            if (3 * min == target) {
                if (i + 1 < high && min == nums[i + 2])
                    result.add(Arrays.asList(firstEle, min, min, min));
                break;
            }                       
            twoSumForThreeSum(nums, i + 1, high, firstEle, min, target - min, result);
        }
        
    }
    
    private void twoSumForThreeSum(int[] nums, int low, int high, int firstEle, int secondEle, int target, List<List<Integer>> result) { 
        if (low >= high) return;
        
        int sum;
        
        while (low < high) {
            sum = nums[low] + nums[high];
            if (sum > target) {
                high--;            
             //   while (low < high && nums[high] == nums[high + 1]) high--;
            }
            else if (sum < target) {
                low++;
             //   while (low < high && nums[low] == nums[low - 1]) low++;
            }
            else {
                result.add(Arrays.asList(firstEle, secondEle, nums[low], nums[high]));
                high--;
                low++;
                while (low < high && nums[low] == nums[low - 1]) low++;
                while (low < high && nums[high] == nums[high + 1]) high--;
            }
        }        
    }
}
