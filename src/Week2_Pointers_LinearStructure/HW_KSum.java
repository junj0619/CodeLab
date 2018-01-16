class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);
        KSum(nums, target, 0, 4, new ArrayList<>(), result);
        return result;
    }
    
    private void KSum(int[] nums, int target, int start, int k, List<Integer> path, List<List<Integer>> result) {
        int len = nums.length;
        if (k * nums[start] > target || k * nums[len - 1] < target) return;
        
        if (k == 2) {
            int left = start;
            int right = len - 1;
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target)
                    right--;
                else if (sum < target)
                    left++;
                else {                
                    result.add(new ArrayList<>(path));
                    result.get(result.size() - 1).addAll(Arrays.asList(nums[left], nums[right]));                    
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                }
            }
            
        } else {
            for (int i = start; i < len - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1])                    
                    continue;
                
                path.add(nums[i]);
                KSum(nums, target - nums[i], i + 1, k - 1, path, result);                
                path.remove(path.size() - 1);
            }            
        }        
    }    
}
