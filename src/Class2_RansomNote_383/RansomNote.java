package Class2_RansomNote_383;

import java.util.HashMap;

/**
 * Created by junjin on 6/9/17.
 *
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        char[] rans = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();

      /* 1) Create magazine <character,count> mapping */
        HashMap<Character, Integer> map = new HashMap<>(); //Key: Character, Value: Count

        for (char ch : mag) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

      /* 2) Check magazine whether contains ransomNote characters and number of characters */
        for (char ch : rans) {
            int num = map.getOrDefault(ch, 0) - 1;
            if (num < 0) return false;
            map.put(ch, num);
        }
        return true;
    }
}
