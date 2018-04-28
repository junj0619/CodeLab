class Solution {
//BackTracking 2
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        res.add(set);
        
        dfs(nums, 0, set, res);
        return res;
    }
    
    private void dfs(int[] nums, int start, List<Integer> set, List<List<Integer>> res) {
        for (int i = start; i < nums.length; i++) {
            set.add(nums[i]);
            res.add(new ArrayList<Integer>(set));
            dfs(nums, i + 1, set, res); // i + 1 ******
            set.remove(set.size() - 1);
        }
    }
}
