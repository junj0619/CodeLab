public class Solution {
    public String removeDuplicateLetters(String s) {
        
        char[] chs = s.toCharArray();
        int[] res = new int[26];   //will contain number of occurences of character (i+'a')
        boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char ch:chs) {  //generate number of occur of character
            res[ch - 'a']++;
        }
        
        for (char ch:chs) {
            int index = ch - 'a';            
            res[index]--;    //decrement number of characters remaining in the string to be analysed
            
            if (visited[index]) {  //if character is already present in stack, then skip
               continue; 
            }
            
            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            //and only removed it when the character occurs later.
            //if input is [c b a] then no remove due to occurs [1, 1, 1]
            while (!stack.isEmpty() && stack.peek() > ch && res[stack.peek() - 'a'] != 0) {
                char c = stack.pop();
                visited[c - 'a'] = false;
            }
            
            stack.push(ch); //add current character and mark it as visited
            visited[index] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {  //pop character from stack and build answer string from end
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
    }
}
