class SelectionSort {
/*
* The algorithm maintains two subarrays in a given array.
*
* 1) The subarray which is already sorted.
* 2) Remaining subarray which is unsorted.
*
* In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked 
* and moved to the sorted subarray.
*
* Time Complexity: O(n2) as there are two nested loops.
*
*
*/
    void sort(int arr[]) {
        int n = arr.length;
        
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIDX = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIDX] > arr[j])
                    minIDX = j;
            }
            
            // Swap the found minimum element with the first element      
            int temp = arr[i];
            arr[i] = arr[minIDX];
            arr[minIDX] = temp;
        }
    }
}
