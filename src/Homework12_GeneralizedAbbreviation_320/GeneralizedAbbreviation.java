//By Bit Manipulation
//How many abbreviations are there for a word of length n? The answer is 2^n.
//0000 word
//0001 wor1
//0010 wo1d
//0011 wo2
//0100 w1rd
//0101 w1r1
//0110 w2d
//0111 w3
//1000 1ord
//1001 1or1
//1010 1o1d
//1011 1o2
//1100 2rd
//1101 2r1
//1110 3d
//1111 4

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        long len = 1 << word.length();
        
        for (long i = 0; i < len; i++) {
            res.add(getAbbreviation(i, word));
        }
        
        return res;
    }
    
    public String getAbbreviation(long num, String word) {
        StringBuilder sb = new StringBuilder();
        int consecutiveOne = 0;
        
        for (int i = 0; i < word.length(); i++) {
            long bit = (num >> i) & 1;
            
            if (bit == 1) {
                consecutiveOne++;
            } else {
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
}
