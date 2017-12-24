class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
    //Time Complexity O(n) = 3n 
    //Space Complexity O(n) = noteChars + magaChars array and noteCount + magaCount array
    //This is not optimization solution, can further reduce space usage and less forloop pass
        char[] noteChars = ransomNote.toCharArray();
        char[] magaChars = magazine.toCharArray();
        
        int[] noteArr = new int[26];
        int[] magaArr = new int[26];
                
        for (char note : noteChars) {
            noteArr[note - 'a']++; 
        } 
        for (char maga : magaChars) {
            magaArr[maga - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (noteArr[i] != 0 && noteArr[i] > magaArr[i])
                return false;
        }
        return true;
    }
    
    //This is optimization solution 1
    //Only use one array to save 26 letters.
    public boolean canConstruct(String ransomNote, String magazine) {
        int magaLen = magazine.length();
        int ransomLen = ransomNote.length();
        int[] count = new int[26];
        
        for (int i = 0; i < magaLen; i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        
        for (int j = 0; j < ransomLen; j++) {            
            if(count[ransomNote.charAt(j) - 'a'] == 0)
                return false;
            count[ransomNote.charAt(j) - 'a']--;
        }
        
        return true;
    }
    //By CharArray Solution 2
      public boolean canConstruct(String ransomNote, String magazine) { 
        int[] count = new int[26];
        
        for (char maga : magazine.toCharArray()) {
            count[maga - 'a']++;
        }
        
        for (char ran : ransomNote.toCharArray()) {            
            if(count[ran - 'a'] == 0)
                return false;
            count[ran - 'a']--;
        }
        
        return true;
    }
  
}
