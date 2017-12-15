class Solution {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) return;
        
        int slow = 0, fast = 0, len = str.length;       
        //Step 1: reverse whole str 
        reverse(str, 0, len - 1);
        
        //Step 2: reverse individual word
        while (fast < len) {
            if (str[fast] == ' ') {
                reverse(str, slow, fast - 1);
                slow = ++fast;
            } else
                fast++;            
        }
        //Step 3: reverse remaining word (the last word)
        reverse(str, slow, len - 1);
    }
    
    private void reverse(char[] str, int start, int end) {
        char temp;
        while (start < end) {
            temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;            
        }
    }
}
