/*Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 *All elements < k are moved to the left
 *All elements >= k are moved to the right
 *Return the partitioning index, i.e the first index i nums[i] >= k.
 *
 *Example
 *If nums = [3,2,2,1] and k=2, a valid answer is 1.
*/


public int partition(int[] arr, int k) {
  int i = -1;
  int j = 0;
  int size = arr.length;
  
  while (j < size) {
    if (arr[j] < k) { //need put smaller only to left
      i++;
      swap(arr, i, j);
    }  
   j++;
  }
  return i + 1;  //return first index of element k
}

private void swap(int[] arr, int i, int j) {
  int temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}
