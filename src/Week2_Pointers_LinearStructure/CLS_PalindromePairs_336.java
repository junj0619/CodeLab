class Solution {
/*
* Given words = ["abcd", "dcba", "lls", "s", "sssll"]
* Return [[0, 1], [1, 0], [3, 2], [2, 4]]
* Ex: sssll  ==>  _ | sssll  prefix = _, suffix = sssll then looking for llsss 
*            ==>  s | ssll   prefix = s  (is Palindrome), suffix = ssll then looking for llss (reverse of suffix) 
*            ==> ss | sll    prefix = ss (is Palindrome), suffix = sll then looking for lls (reverse of suffix)
*            ==>sss | ll     prefix = sss (is Palindrome), suffix = ll (is Palindrome) then looking for ll (reverse of suffix)  
*                                                                                                   and sss (reverse of prefix)
*           ==>sssl | l      prefix = sssl, suffix = l (is Palindrome) then looking for lsss (reverse of prefix)
*
* As result: All possible Palindrome for "sssll" are { llsss, llss, lls, ll, sss, lsss }
*                               ==> { llsss, llss, lls, ll } + "sssll" + { sss, lsss }
*/
    
    HashMap<String, Integer> map = new HashMap<>(); // Key : word, Value: Index
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> palindromePairs(String[] words) {        
        if (words == null || words.length < 2) return ans;
        
        int len = words.length;       
        
        for (int i = 0; i < len; i++) { 
            map.put(words[i], i); 
        }
        
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int wordLen = word.length();
            //Put (j <= wordLen) to trade both front and end as empty str, Failing test case ['a', ''] => [[0, 1], [1, 0]]       
            for (int j = 0; j <= wordLen; j++) {
                String prefix = word.substring(0, j);  //'', 'a'
                String suffix = word.substring(j);     //'a',''
                
                if (isPalindrome(prefix)) {
                    String revSuffix = reverseString(suffix);  
                    if (map.containsKey(revSuffix))                        
                        addToAns(revSuffix, map.get(revSuffix), i);              
                }
                //Avoid duplicated (suffix.length() != 0)
                if (suffix.length() != 0 && isPalindrome(suffix)) {
                    String revPrefix = reverseString(prefix);
                    if (map.containsKey(revPrefix))
                        addToAns(revPrefix, i, map.get(revPrefix));                                                          
                }
            }
            
        }
        
        return ans;        
    }
    
    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true;
    }
    
    private String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    private void addToAns(String str, int i, int j) {
         if (i != j) {                    
             List<Integer> list = new ArrayList();
             list.add(i);
             list.add(j);
             ans.add(list);                        
        }   
    }
}
