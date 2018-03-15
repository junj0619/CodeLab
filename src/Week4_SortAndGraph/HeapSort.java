public class HeapSort {
/**
* Time Complexity: Time complexity of heapify is O(Logn). Time complexity of createAndBuildHeap() is O(n) 
*                  and overall time complexity of Heap Sort is O(nLogn).
*
**/
    public void sort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, i, n);
        // One by one extract an element from heap
        for (int j = n - 1; j >= 0; j--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            
            // Call max heapify on the reduced heap
            heapify(arr, 0, j);
        }

    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public void heapify(int[] arr, int i, int len) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < len && arr[left] > arr[max])
            max = left;

        if (right < len && arr[right] > arr[max])
            max = right;

        if (max != i) {
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
            
            // Recursively heapify the affected sub-tree
            heapify(arr, max, len);
        }
    }
}
