//Use Two pointer + HashMap
//Slow pointer pointing to start point of subString
//Fast pointer pointing to end point of subString
//HashMap maintain each char frequences
//
//Each time put new char into HashMap, check if map.size is greater than k
//if yes means map contains more distinct char than K.
//so remove from Slow pointer until meet map.size == k
//The remove operation means two things:
//  1) current remove char freq > 1, then freq--;
//  2) current remove char freq = 1, then remove this key,pairs from Hashmap
//
//Time complexity : as the two pointers keep moving forward, the time complexity will be O(n)
//Space Complexity: as we use a hashmap to maintain the frequency, space complexity will be O(n)

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
       
        int fast = 0;
        int slow = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>(); //Key: char, value: frequency
        
        for (fast = 0; fast < s.length(); fast++) {
           char ch = s.charAt(fast);
           map.put(ch, map.getOrDefault(ch, 0) + 1);
           
           while (map.size() > k) {
             char c = s.charAt(slow);
             int freq = map.get(c);
               
             if (freq == 1) {
                 map.remove(c);
             } else {
                 map.put(c, freq - 1);
             }      
               
             slow++;
           }            
          len = Math.max(len, fast - slow + 1);        
        }
        return len;
    }
}
