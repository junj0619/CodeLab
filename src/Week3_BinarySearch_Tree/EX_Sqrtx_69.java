class Solution {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        long start = 0, end = x;
        
        while (start < end - 1) {
            long mid = start + (end - start) / 2;
            
            if (mid * mid == x)
                return (int) mid;
            else if (mid * mid > x)
                end = mid;
            else
                start = mid;
        }
        //26, 25
        if (end * end <= x)
            return (int) end;
        else 
            return (int) start;
    }
}
