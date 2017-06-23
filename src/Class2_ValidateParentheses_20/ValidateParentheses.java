package Class2_ValidateParentheses_20;

import javax.xml.stream.events.Characters;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * Created by junjin on 6/13/17.
 * <p>
 * Input : {[()]}
 * Output: true
 * <p>
 * Input : ]})
 * Output: false
 *
 * Input : ()[]{}
 * Output: true
 *
 * Input : ((]]
 * Output: false
 *
 * Input : ([])}
 * Output: false
 *
 * Time Complexity : O(n) because loop char array once
 * Space Complexity: O(n) save all open input worst case every in char is open
 * <p>
 * <p>
 * follow up 1: Ignore all other characters
 * follow up 2: Improve function extendability. Don't hard code brackets in the validation function
 */
public class ValidateParentheses {
    public static void main(String[] args) {
        String p = "]})";
//        System.out.println("Result :" + validate(p));


//        String pExt = "{[()]}";
//        String pExt = "axaxaxa{[a(ssss)daaaaa]d}";
        String pExt = "asd}])";

        HashMap<Character, Character> map = new HashMap<>(); //Key: open  brackets, value: close  brackets

        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        System.out.println("Result: " + validateExt(pExt, map));
    }

    public static boolean validate(String parentheses) {
        if (parentheses.isEmpty()) return true;

        char[] ch = parentheses.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int mid = ch.length / 2;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(')
                stack.push(')');
            else if (ch[i] == '{')
                stack.push('}');
            else if (ch[i] == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != ch[i]) {
                return false;
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static boolean validateExt(String parentheses, HashMap<Character, Character> map) {
        /*
        * Follow up 1: For any non-parentheses character jump to next iteration
        *
        * Follow up 2: For extendability, Use HashMap to save open close such as <[,]>,<{,}>,<(,)>
        *              Use map to check input character whether or no in the key.
        *              If contains in the map then push map.val into stack.
        *              Means correct matching parentheses should be close
        *
        *              If current char is not the map keys. Then check whether is close
        *              Then check map values contains current char or not
        *              If contains then pop stack element to compare current char value
        *              Not equal then false;
        *
        *              If current char not in the map keys or value.
        *              Then means skip character
        * */

        if (parentheses.length() == 0) return true;

        char[] ch = parentheses.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])) {
                stack.push(map.get(ch[i]));
            } else if (map.containsValue(ch[i])) {
                if (stack.isEmpty() || ch[i] != stack.pop()) { //Check stack is empty for more close brackets input
                    return false;                              // Such as : ])}
                }
            } else {      // Skip all other characters for follow up 1
                continue;
            }
        }

        if (!stack.isEmpty()) return false;

        return true;
    }

}
