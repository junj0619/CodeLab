class Solution {
//Time Complexity: O(n) one pass
//Space Complexity: O(n) HashMap
//Test Cases: [] T:0 => [], [2, 1, 3] T:5 => [0,2], [1] T:1 => [], [3,3] T:6 =>[0, 1]

    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>(); //Key : target - cur, Val : Index
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else
                map.put(target - nums[i], i);
        }
        return new int[2];
    }
}
