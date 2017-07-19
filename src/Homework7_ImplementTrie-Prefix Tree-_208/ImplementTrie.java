public class Trie {

    class TrieNode {
        private boolean isEnd;
        
        private int R = 26; //number of alphabets
        
        private TrieNode[] links;
        
        public TrieNode() {
            links = new TrieNode[R];    
        }
        
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
        
        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }
        
        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
        
        public void setEnd() {
            isEnd = true;
        }
        
        public boolean isEnd() {
            return isEnd;
        }
    }
    
    
    
    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root =  new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root; //Reset node back to root each item to insert new word.
      for(int i = 0; i < word.length(); i++) {
          char ch = word.charAt(i);
          if(!node.containsKey(ch)) {
            node.put(ch, new TrieNode());  
          } 
          node = node.get(ch); //Move to next level
      }
        node.setEnd();       
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
       TrieNode node = searchPrefix(word);
       return node != null && node.isEnd; // fully match.
    }
    
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }           
        }
        
         return node;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null; //not need to do fully match
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
