public class QuickSort {
//Avg Time Complexity: nlog(n)
//Worest Case: n2

    public static void main(String[] args) {
        int[] arr = {5, 6, 2, 1, 3, 2, 10, 7, 4, 8, 9};

        quickSort(arr, 0 , arr.length - 1);
        for (int num : arr) {
            System.out.print(num + ", ");
        }
    }

    public static void quickSort(int[] arr, int start, int end){
        if(start > end) return;

        int position = partition(arr, start, end);
        quickSort(arr, start, position - 1);
        quickSort(arr, position + 1, end);
    }

    private static int partition(int[] arr, int start, int end){

        int j = start;
        int i = start - 1;
        int pivot = arr[end];

        while(j <= end) {
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
            j++;
        }
        return i;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
