// Java program for implementation of QuickSort
class QuickSort
{
/* Time Complexity: Average Case O(nLogn),
* Worst Case O(n^2)
* Worst Case: The worst case occurs when the partition process always picks greatest or smallest element as pivot. 
*             If we consider above partition strategy where last element is always picked as pivot, 
*             the worst case would occur when the array is already sorted in increasing or decreasing order. 
*
*/


    private void sort(int[] nums, int low, int hi) {
        if (low >= hi) return;
        
        int index = partition(nums, low, hi);
        sort(nums, low, index - 1);
        sort(nums, index + 1, hi);                
    }
    
    private int partition(int[] nums, int low, int hi) {
        int pivot = nums[hi];
        int j = low - 1;
        
        for (int i = low; i < hi; i++) {
            if (nums[i] <= pivot) {                
                swap(nums, i, ++j);                        
            }
        }        
        
        swap(nums, hi, ++j);
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;                
    }  
}    
