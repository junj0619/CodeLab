class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        /*
        * 1)  0/x = 0
        * 2) -1/-1 = 1 or 1/1 = 1
        * 3) -1/1 = -1 or 1/-1 = -1
        * 4)  Integer.Max + (1 ~ n) / 1 = Integer.Max + (1 ~ n)
        * 5)  1/5 = 0.2
        * 6)  1/3 = 0.(3)
        */
        //1)
        if (numerator == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        //2), 3)
        if (numerator < 0 ^ denominator < 0)
            sb.append("-");
        //4)
        Long a = Math.abs(Long.valueOf(numerator));
        Long b = Math.abs(Long.valueOf(denominator));
        Long r = a % b;
        
        sb.append(a/b);
        
        if (r == 0) 
            return sb.toString();
        
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        
        while (r != 0) {
            if (map.containsKey(r)) { //6)    1/99 = 0.(01)                
                sb.insert(map.get(r), "(");
                sb.append(")");                                
                break;
            }
            
            map.put(r, sb.length());
            r *= 10;
            sb.append(r / b);   //5)
            r %= b;
        }                    
        
        return sb.toString();        
    }
}
