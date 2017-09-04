class Solution {
    
     class Abbre {
           String abbre;
           int len;
           
           Abbre(String abbre, int len) {
               this.abbre = abbre;
               this.len = len;
           }
       }
        
    public String minAbbreviation(String target, String[] dictionary) {
       if (dictionary == null || dictionary.length == 0) 
           return String.valueOf(target.length());       
        
       List<String> abbrList = generatedAbbrList(target);
        
       List<Abbre> sortAbbrList = sortAbbrList(abbrList);
        
       for (Abbre abbr : sortAbbrList) {
           boolean isConfilt = true; 
                                  
           for (String dict : dictionary) {               
               isConfilt = isValidAbbr(abbr.abbre, dict);                 
               if (isConfilt) break;
           }   
           
           if (!isConfilt) return abbr.abbre;
        }   
        
        return "";
    }
    
    public List<Abbre> sortAbbrList(List<String> strs) {
        List<Abbre> res = new ArrayList<>();
        
        for (String str : strs) {
            int len = 1;
            for (int i = 1; i < str.length(); i++) {                
                char pre = str.charAt(i - 1);
                char curr = str.charAt(i);
                if (pre >= '0' && pre <= '9' && curr >= '0' && curr <= '9') {
                    continue;
                }
                len++;
            }
            res.add(new Abbre(str, len));
        }
        
        res.sort((abbr1, abbr2) -> abbr1.len - abbr2.len);
        
        return res;
    }
    
    public List<String> generatedAbbrList(String target) {
        List<String> res = new ArrayList<>();
        int len = 1 << target.length();
        
        for (int i = 0; i < len; i++) {
            res.add(generatedAbbr(target, i));
        }
        
        return res;
    }
    
    public String generatedAbbr(String word, long num) {
        StringBuilder sb = new StringBuilder();
        int consecutiveOne = 0;
        
        for (int i = 0; i < word.length(); i++) {
            long bit = num >>> i & 1;            
                
            if (bit == 1) {
                consecutiveOne++;
            } 
            else {
                if (consecutiveOne != 0) {
                    sb.append(consecutiveOne);
                    consecutiveOne = 0;
                }
                sb.append(word.charAt(i));
            }                      
        }
        
        if (consecutiveOne != 0) {            
            sb.append(consecutiveOne);
        }
        
        return sb.toString();
    }
    
    public boolean isValidAbbr(String abbr, String word) {
        
        int abbrLen = abbr.length(), wordLen = word.length();
        int i = 0, j = 0;
        
        while (i < abbrLen && j < wordLen) {
            
            if (abbr.charAt(i) == word.charAt(j)) {
                ++i;
                ++j;
                continue;
            }
            
            if (abbr.charAt(i) <= '0' || abbr.charAt(i) > '9') {
                return false;
            }
            
            int start = i;
            while (i < abbrLen && abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9') {
                ++i;               
            }            
            
            j += Integer.valueOf(abbr.substring(start, i));                        
        }
        
        return (i == abbrLen) && (j == wordLen);
    }
}
