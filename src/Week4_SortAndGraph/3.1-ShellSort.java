/* Java implementation of ShellSort
*  https://www.geeksforgeeks.org/shellsort/
*  https://www.tutorialspoint.com/data_structures_algorithms/shell_sort_algorithm.htm
*
* Time Complexity: Time complexity of above implementation of shellsort is O(n2). 
* In the above implementation gap is reduce by half in every iteration. 
* There are many other ways to reduce gap which lead to better time complexity. 
*
*/

class ShellSort
{
  public void sort(int[] nums) {
        int len = nums.length;
        // Start with a big gap, then reduce the gap
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int temp = nums[i];
                int pos;
                for (pos = i; pos >= gap && nums[pos - gap] > temp; pos -= gap) 
                    nums[pos] = nums[pos - gap];
                    
                // put temp (the original a[i]) in its correct
                nums[pos] = temp;
            }
        }
    }
    
}    
