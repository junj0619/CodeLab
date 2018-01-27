// "static void main" must be defined in a public class.
public class Main {
    private static int[] helper;
    public static void main(String[] args) {
        int[] arr = new int[] {2,7,4,9,1,0,3,4,2,9,7,8,6};
        int len = arr.length;
        helper = new int[len];
        mergeSort(arr, 0, len - 1);
        
        for (int num : arr) {
            System.out.printf(num + ",");
        }
    }
    
    public static void mergeSort(int[] arr, int s, int e) {
        if (s == e) return;
        
        int m = (s + e) >>> 1;
        mergeSort(arr, s, m);
        mergeSort(arr, m + 1, e);
        merge(arr, s, m, e);
    }
    
    private static void merge(int[] arr, int s, int m, int e) {
        int first = s;
        int sec = m + 1;        
        int k = s;
        
        for (int low = s; low <= e; low++) {
            helper[low] = arr[low];
        }
        
        while (first <= m && sec <= e) {
            if (helper[first] < helper[sec]) {
                arr[k] = helper[first++];                
            } 
            else {
                arr[k] = helper[sec++];
            }        
            k++;
        }
        
        while (first <= m) {
            arr[k++] = helper[first++];            
        }                
    }
}
