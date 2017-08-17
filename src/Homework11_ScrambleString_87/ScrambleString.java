public class Solution {
    public boolean isScramble(String s1, String s2) {
        //Step 1 base condition         
        if(s1 == null || s2 == null || s1.length() != s2.length()) return false;
        if (s1.length() == 1 && s1.equals(s2)) return true;
        //coner case: if s1 != s2 return false
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
            
        Arrays.sort(char1);
        Arrays.sort(char2);
        
        String str1 = new String(char1);
        String str2 = new String(char2);
        
        if(!str1.equals(str2)) return false;
        
        //Step 2 check each substring compare s1 to s2 
        int len = s1.length();
        for(int i = 1; i < len; i++) {                             
            String s1Left = s1.substring(0, i);
            String s1Right = s1.substring(i);
            
            if((isScramble(s1Left, s2.substring(0, i)) && isScramble(s1Right, s2.substring(i))) 
            || (isScramble(s1Left, s2.substring(len - i)) && isScramble(s1Right, s2.substring(0, len - i))))
                return true;
        }
        
        return false;
    }
}
