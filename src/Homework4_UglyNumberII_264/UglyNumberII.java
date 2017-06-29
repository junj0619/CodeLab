public class Solution {
    public int nthUglyNumber(int n) {
        
        /*
         *  (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
         *  (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
         *  (3) 1×5, 2×5, 3×5, 4×5, 5×5, … 
         *
         *
        */
        
        List<Integer> ugly = new ArrayList<>();
        ugly.add(1);
        
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        
        for (int i = 1; i < n; i++) {
            int lastNumber = ugly.get(i - 1);
            
            if (ugly.get(p2) * 2 == lastNumber) p2++;
            if (ugly.get(p3) * 3 == lastNumber) p3++;
            if (ugly.get(p5) * 5 == lastNumber) p5++;
            
            ugly.add(Math.min(Math.min(ugly.get(p2) * 2, ugly.get(p3) * 3), ugly.get(p5) * 5));            
        }
        
        return ugly.get(n - 1);
    }
}
