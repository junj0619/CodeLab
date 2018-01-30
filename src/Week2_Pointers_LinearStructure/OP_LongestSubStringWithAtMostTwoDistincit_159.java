class Solution {
/*Approach #1: Brute force silding window O(n2)
 *e b e a c
 *[]
 *[ ]
 *[   ]    <== max = 3
 *[     ]  reset HashSet size == 2 && !contains cur char
 *  [  ]
 *  [    ]  reset HashSet size == 2 && !contains cur char
 *......  []
*/
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        
        HashSet<Character> set = new HashSet<>();
        int slow = 0, fast = 0, len = s.length(), ans = 0;
        char[] chars = s.toCharArray();
        
        while (slow < len && fast < len) {
            if (set.size() == 2 && !set.contains(chars[fast])) {
                set = new HashSet<>();            
                slow++;
                fast = slow;
                continue;
            }
                
            if (!set.contains(chars[fast]))                 
                set.add(chars[fast]);
            
            ans = Math.max(ans, fast - slow + 1);
            fast++;                       
        }
        return ans;
    }
}
