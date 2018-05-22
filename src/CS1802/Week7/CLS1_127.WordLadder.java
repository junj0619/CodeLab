class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;        
                
        Set<String> visited = new HashSet<>();
        Set<String> words = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        
        for (String word : wordList) {
            words.add(word);
        }
        
        int len = beginWord.length();
        int count = 0;
        q.offer(beginWord);
        visited.add(beginWord);
        
        while (!q.isEmpty()) {  
            count++;
            int size = q.size();            
            
            for (int l = 0; l < size; l++) {                
                String str = q.pollFirst();   
                
                for (int i = 0; i < len; i++) {                                     
                    for (char c = 'a'; c <= 'z'; c++) {
                        String replaced = replace(str, i, c);
                    
                        if (replaced.equals(endWord)) return count + 1; 
                        
                        if (!visited.contains(replaced) && words.contains(replaced)) {
                            q.offerLast(replaced);
                            visited.add(replaced);                        
                        }                                                                                 
                    }
                }
                
            }
        }
        return 0;
    }    
    
    private String replace(String str, int pos, char ch) {
        char[] chars = str.toCharArray();
        chars[pos] = ch;
        return new String(chars);
    }
}
