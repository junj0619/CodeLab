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
    
/* LC Approach: one pass siding windows O(n)
* "The main idea is to maintain a sliding window with 2 unique characters. 
*  The key is to store the last occurrence of each character as the value in the hashmap. 
*  This way, whenever the size of the hashmap exceeds 2, 
*  we can traverse through the map to find the character with the left most index, 
*  and remove 1 character from our map. Since the range of characters is constrained, 
*  we should be able to find the left most index in constant time."
* 
* e c e b a
* []           [e, 0] max = 1 - 0 = 1
* [ ]          [e, 0], [c, 1] max = 2 - 0 = 2
* [   ]        [e, 2], [c, 1] max = 3 - 0 = 3
* [     ]      [e, 2], [c, 1], [b, 3]  => [e, 2], [b, 3]  leftMost = 1, lo = 1 + 1 = 2
*     [ ]      ,max = 4 - 2 = 2
*     [    ]   [e, 2], [b, 3], [a, 4] => [b, 3], [a, 4] leftMost = 2, lo = 2 + 1 = 3
*	    [  ]   ,max = 5 - 3 = 2
*
*/               


    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() < 1) return 0;
        
        HashMap<Character, Integer> map = new HashMap<>(); //Key: char, Value: most right index;
        int hi = 0, low = 0, maxLen = 0, len = s.length();
        char[] chars = s.toCharArray();
        
        while (hi < len) {
            if (map.size() <= 2) {
                map.put(chars[hi], hi);
                hi++;
            }
            
            if (map.size() > 2) {
                int leftMost = len;
                for (int idx : map.values()) 
                    leftMost = Math.min(leftMost, idx);                
                map.remove(chars[leftMost]);           
                low = leftMost + 1;
            }           
            
            maxLen = Math.max(hi - low, maxLen);
        }
        return maxLen;        
    }
    
}
