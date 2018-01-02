class Solution {
//''       ==> true
//'['      ==> false
//']'      ==> false
//'[}'     ==> false
//'[({'    ==> false
//'[({})]' ==> true

    public boolean isValid(String s) {
        if (s == null || s == "") return true;
        
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char ch : chars) {
            if (ch == '(')
                stack.push(')');
            else if (ch == '{')
                stack.push('}');
            else if (ch == '[')
                stack.push(']');
            else if (stack.isEmpty() || !stack.isEmpty() && stack.pop() != ch)
                return false;            
        }
        
        return stack.isEmpty();
    }
}
