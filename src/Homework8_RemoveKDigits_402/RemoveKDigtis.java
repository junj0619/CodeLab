public class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) return "0";
        
        Deque<Character> stack =  new ArrayDeque<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        String res;
        
        while (i < len) {
            char ch = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
            i++;
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        sb.reverse();
        
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
