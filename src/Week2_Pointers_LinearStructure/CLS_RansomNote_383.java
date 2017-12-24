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
}
