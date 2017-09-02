class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        
        int i = 0, j = 0;
        int wordLen = word.length(), abbrLen = abbr.length();
        
        while (i < wordLen && j < abbrLen) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;
                ++j;
                continue;
            }
            
            // word : "a", abbr : "01" ==> false
            // first char of abbr can not be '0'            
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            
            int start = j;
            while (j < abbrLen && abbr.charAt(j) >= '0' && abbr.charAt(j) <='9' ) {
                ++j;
            }
            
            i += Integer.valueOf(abbr.substring(start, j));
        }
        
        return i == wordLen && j == abbrLen;
    }
}
