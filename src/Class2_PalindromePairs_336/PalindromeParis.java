package Class2_PalindromePairs_336;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by junjin on 6/19/17.
 * <p>
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * <p>
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]]
 * The palindromes are ["battab", "tabbat"]
 * <p>
 * Example 2:
 * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 *
 * Input : ["a",""]
 * Output: [[0,1],[1,0]]
 * j = 0
 * str1 = ""
 * str2 = "a"
 * [0,1] from second if
 *
 * j = 1
 * str1 = "a"
 * str2 = ""
 * [1,0] from first if
 * second if fail because str2.length = 0
 */
public class PalindromeParis {

    public static void main(String[] args) {
        String[] strs = {"aba", "a"};
        List<List<Integer>> list = palindromeParis(strs);

        for (List<Integer> i : list) {
            System.out.printf("{" + i.get(0) + "," + i.get(1)+"}");
        }

    }


    /*
     * Step 1: Save all words in HashMap with Key:Word, Value:Index
     * Step 2: Iterate each word from words
     * Step 3: Check current word palindrome pair whether or not in the HashMap
     * Step 4: If exist add to the return list
     * */

    public static List<List<Integer>> palindromeParis(String[] strs) {
        List<List<Integer>> returnList = new ArrayList<>();

        //Step 1:
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.put(strs[i], i);
        }

        //Step 2:
        for (int i = 0; i < strs.length; i++) {

            //Step 3
            //Maintain two strings, if first string is palindrome. Then reverse second string must be a palindrome pair
            //Such as [aba] => j = 0 => str1="" , str2="aba"; then reverse str2 become "aba". Must be a palindrome pair
            //              => [aba]+[aba]=[abaaba]
            //        [aba] => j = 1 => str1="a", str2="ba"; str1 is palindrome so reveser str2 become "ab". Must be
            //        palindrome pair =>  [ab]+[aba]=>[ababa]
            //
            //If str1(prefix) is palindrome then reverse str2(suffix)
            //   then put in front of prefix. It will be palindrome pair
            //
            //If str2(suffix) is palindrome then reverse str1(prefix)
            //   then put after suffix. It will be palindrome pair.

            /*** Notice that: j<= words[i].length(); it is for empty string pair
             Input: ["a",""]
             Output: [[0,1]] (added from second if(isPalindrome(str)))
             only < without =
             Expected: [[0,1],[1,0]]
             ***/

             /*The <= in for (int j=0; j<=words[i].length(); j++) is aimed to handle empty string in the input.
              Consider the test case of ["a", ""];
             */
            for (int j = 0; j <= strs[i].length(); j++) {
                String str1 = strs[i].substring(0, j);
                String str2 = strs[i].substring(j);

                if (isPalindrome(str1)) {
                    String str2Rev = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2Rev) && map.get(str2Rev) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(str2Rev)); //insert to prefix
                        list.add(i);
                        returnList.add(list);
                    }
                }

                if (isPalindrome(str2)) {
                    String str1Rev = new StringBuilder(str1).reverse().toString();
                    /*Since we now use <= in for (int j=0; j<=words[i].length(); j++) instead of <.
                      There may be duplicates in the output (consider test case ["abcd", "dcba"]).
                      Therefore I put a str2.length()!=0 to avoid duplicates.
                    */
                    if (map.containsKey(str1Rev) && map.get(str1Rev) != i && str2.length() != 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(str1Rev)); //insert to suffix
                        returnList.add(list);
                    }
                }
            }
        }

        return returnList;
    }

    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        char[] chars = str.toCharArray();
        while (i <= j) {
            if (chars[i++] != chars[j--])
                return false;
        }
        return true;
    }


}
