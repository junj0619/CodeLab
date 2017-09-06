class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) >> 1;


        while (start + 1 < end) {

            mid = (start + end) >> 1;

            if (nums[mid] > nums[end]) {

                if (nums[mid] < target) {
                    start = mid;
                } else if (nums[mid] > target) {
                    if (target > nums[end]) {
                        end = mid;
                    } else if (target < nums[end]) {
                        start = mid;
                    } else {
                        return end;
                    }
                } else {
                    return mid;
                }
            } else {

                if (nums[mid] > target) {
                    end = mid;
                } else if (nums[mid] < target) {
                    if (target < nums[end]) {
                        start = mid;
                    } else if (target > nums[end]) {
                        end = mid;
                    } else {
                        return end;
                    }
                } else {
                    return mid;
                }
            }
        }


        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
}
