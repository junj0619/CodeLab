public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(subsets, new ArrayList<>(), nums, 0);
        return subsets;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int index) {
        list.add(new ArrayList<>(temp));
        
        for(int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }        
    }
}
