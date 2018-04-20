class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                    return true;
            }
            if (nums[start] == nums[end] && nums[mid] == nums[start]) {
                start++;
                end--;
            } else {
                if (nums[mid] > target) {
                    if (nums[mid] > nums[end] && target < nums[start]) { //on left and target < first
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (nums[mid] <= nums[end] && target > nums[end]) { //on right and target > last  eg.[3,1,1] Target = 3
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
        return false;        
    }
}
