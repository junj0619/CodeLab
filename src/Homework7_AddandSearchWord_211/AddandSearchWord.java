public class WordDictionary {

    class TrieNode {
        
        private int size = 26;
        public TrieNode[] links;
        private boolean isEnd;
        
        public TrieNode() {
            links = new TrieNode[size];            
        }
        
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
        
        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
        
        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }
        
        public void setEnd() {
            this.isEnd = true;        
        }
        
        public boolean isEnd() {
            return isEnd;
        }
    
    }
    
    /** Initialize your data structure here. */
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();      
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        
        TrieNode node = root;
        Deque<TrieNode> queue = new ArrayDeque<>();
        queue.offer(node);
        int index = 0;
        
        while(index < word.length()) {
            
          int size = queue.size();
            
          for (int i = 0; i < size; i++) {
                            
                TrieNode cur = queue.poll();
                char ch = word.charAt(index);
                
                if(ch != '.') {
                    if(cur.containsKey(ch)) {
                         if (cur.get(ch).isEnd() && index == word.length() - 1) {
                             return true;
                         }   
                        queue.offer(cur.get(ch));
                    }                
                } else {
                    for (int j = 0; j < 26; j++) {
                        TrieNode curNode = cur.links[j];
                        if (curNode != null) {
                            if(curNode.isEnd() && index == word.length() - 1) {
                                return true;
                            }
                            queue.offer(curNode);
                        }
                    }
                }
            }
            
            index++;
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
