/**
* Bubble Sort
* Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
*
* Example:
* First Pass:
* ([5] [1] 4 2 8 ) –> ([1] [5] 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
* ( 1 [5] [4] 2 8 ) –>  ( 1 [4] [5] 2 8 ), Swap since 5 > 4
* ( 1 4 [5] [2] 8 ) –>  ( 1 4 [2] [5] 8 ), Swap since 5 > 2
* ( 1 4 2 [5] [8] ) –> ( 1 4 2 [5] [8] ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.
*
* Second Pass:
* ( [1] [4] 2 5 8 ) –> ( [1] [4] 2 5 8 )
* ( 1 [4] [2] 5 8 ) –> ( 1 [2] [4] 5 8 ), Swap since 4 > 2
* ( 1 2 [4] [5] 8 ) –> ( 1 2 [4] [5] 8 )
* ( 1 2 4 [5] [8] ) –>  ( 1 2 4 [5] [8])
* Now, the array is already sorted, but our algorithm does not know if it is completed. 
* The algorithm needs one whole pass without any swap to know it is sorted.
* 
* Third Pass:
* ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
* ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
* ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
* ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
*
* Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
* Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
* Stable: Yes
*
**/

class BubbleSort {
    public void bubbleSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < arr[j]) { //then swap adjacent elements
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

/*
 * Optimized Implementation:
 * The above function always runs O(n^2) time even if the array is sorted.  
 * It can be optimized by stopping the algorithm if inner loop didn’t cause any swap.	
 **/
    public void bubbleSort2(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < arr[j]) { //then swap adjacent elements
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

}

