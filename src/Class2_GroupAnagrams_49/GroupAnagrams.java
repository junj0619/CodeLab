package Class2_GroupAnagrams_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by junjin on 6/19/17.
 * <p>
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 *
 * Time Complexity : n * nlog(n) = n(from String array iteration) * nlog(n)(from Arrays.sort)
 * Space Complexity: o(n) build n unique sorted pairs in Hashmap
 */
public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>(); //Key: Sorted string, Value: same string after sort
                                                             //ate => <aet,{ate,eat,tea}>

        for (String s : strs) {
            //Step 1: Convert s to char array, so we can sort it to get distinct string
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);

            //Step 2: Check and save sorted string in to Map
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<String>()); //Remember List Interface was implement by ArrayList
            }
            map.get(str).add(s);
        }

        //Step 3: extract all the List<String> from the map, build return type List<List<String>>
        return new ArrayList<List<String>>(map.values());
        //Remember Can Not new List !! List is a interface that is implemented by ArrayList
        //So new ArrayList
    }
}
