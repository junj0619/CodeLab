class Solution {
    /*
    *  Approach 1#:
    *  Quick Select : O(n) = n + n/2 + n/4 + ..... < 2n => n
    *
    *  Approach 2#:
    *  MinHeap O(k + (n-k)logk)
    */
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);  //Change to 0 Base Smallest
    }
    //QuickSort Partition
    private int findKthLargest(int[] nums, int start, int end, int k) {
        if (start > end) return Integer.MIN_VALUE;
        
        int pivot = nums[end];
        int pos = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) 
                swap(nums, i, pos++);
        }                
        swap(nums, end, pos);
        
        if (pos == k)
            return nums[pos];
        else 
            return pos > k ? findKthLargest(nums, start, pos - 1, k) : findKthLargest(nums, pos + 1, end, k);           
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
