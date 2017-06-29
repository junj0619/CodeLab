/**
* primes = [2, 7, 13, 19], K = 12 
* Output: [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]
*
*
*
*  Time Complexity: O(n2)
* Space Complexity: O(n)
*
* Runtime: 123 ms
* Beats : 8.79%
*
**/


public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        List<Integer> ugly = new ArrayList<>();
        int[] primesUsedCount = new int[primes.length];
        ugly.add(1);
        
        for(int i = 1; i < n; i++) {
            int last = ugly.get(i -1);
            ugly.add(Integer.MAX_VALUE);
            
            for(int j = 0; j < primes.length; j++) {
                
                if(ugly.get(primesUsedCount[j]) * primes[j] == last) { 
                    primesUsedCount[j]++; 
                }
                
                ugly.set(i, Math.min(ugly.get(i), ugly.get(primesUsedCount[j]) * primes[j]));
            }
        }
    
        return ugly.get(n - 1);
    }
}
