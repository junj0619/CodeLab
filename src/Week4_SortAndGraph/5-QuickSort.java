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


   private int partition(int[] arr, int low, int hi) {
	    int pivot = arr[hi];
	    int i = low;
	    int j = i - 1;
	    
	    while (i <= hi) {
	        if (arr[i] <= pivot) {
	            j++;
	            int temp = arr[j];
	            arr[j] = arr[i];
	            arr[i] = temp;
	        }
	        i++;     
	    }
	    return j;
	}

    void sort(int[] arr, int low, int hi) {
        if (low >= hi) return;
        
        int index = partition(arr, low, hi);
        sort(arr, low, index - 1);
        sort(arr, index + 1, hi);
    }
}    
