class MergeSort
{
/*
* Time Complexity: O(nLogn) in all 3 cases (worst, average and best)
* Auxiliary Space: O(n)
* Algorithmic Paradigm: Divide and Conquer
* Sorting In Place: No in a typical implementation
* Stable: Yes
*
*/
    
    void merge(int[] arr, int low, int mid, int hi) {
        int leftLen = mid - low + 1;
        int rightLen = hi - mid;
        int[] left = new int[leftLen];
        int[] right = new int[rightLen];
        
        for (int i = 0; i < leftLen; i++)
            left[i] = arr[low + i];
        for (int j = 0; j < rightLen; j++)
            right[j] = arr[mid + 1 + j];
        
        int i = 0, j = 0, k = low;
        
        while (i < leftLen && j < rightLen) {
            arr[k++] = left[i] <= right[j] ? left[i++] : right[j++];  //left[i] <= right[j]: will make sort stable
        }
        
        while (i < leftLen) arr[k++] = left[i++];
        while (j < rightLen) arr[k++] = right[j++];
    }
    
	void mergeSort(int[] arr, int low, int hi) {
	    if (low >= hi) return;
	    
	    int mid = low + (hi - low) / 2;
	    mergeSort(arr, low, mid);
	    mergeSort(arr, mid + 1, hi);
	    merge(arr, low, mid, hi);
	}
}
