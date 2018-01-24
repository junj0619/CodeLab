class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return false;
        
        char[] chars = num.toCharArray();
        int len = chars.length;
        int start = 0;
        int end = len - 1;
        
        while (start < end) {
            if ((chars[start] == '6' && chars[end] == '9') || (chars[start] == '9' && chars[end] == '6')) {
                start++;
                end--;
                continue;
            }
                         
            if (chars[start] != chars[end])                     
                return false;
            if (chars[start] != '1' && chars[start] != '8' && chars[start] != '0')
                return false;
            if (chars[end] != '1' && chars[end] != '8' && chars[end] != '0')
                return false;
            start++;
            end--;
        }
        
        if (len % 2 == 1 && chars[len / 2] != '1' && chars[len / 2] != '8' && chars[len / 2] != '0')
            return false;
            
        return true;                        
    }
    
    //Approach #2: simplfy code by HashTable
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return false;
        
        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        
        int start = 0, end = num.length() - 1;
        
        while (start <= end) {
            if (!map.containsKey(num.charAt(start)) || !map.containsKey(num.charAt(end))) return false;
            if (num.charAt(start) != map.get(num.charAt(end))) return false;
            start++;
            end--;
        }
        return true;
    }
}
