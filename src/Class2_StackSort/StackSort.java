package Class2_StackSort;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by junjin on 6/9/17.
 * <p>
 * | 3 |      | 4 |
 * | 1 |  ==> | 3 |
 * | 4 |      | 2 |
 * | 2 |      | 1 |
 * <p>
 * Time Complexity : O(n2)
 * Space Complexity: O(n)
 */
public class StackSort {

    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<>();
        stack.offer(3);
        stack.offer(1);
        stack.offer(4);
        stack.offer(2);

        sortStack(stack);

        for (int num : stack) {
            System.out.println(num);
        }
    }

    public static void sortStack(Deque<Integer> stack) {
        Deque<Integer> helperStack = new ArrayDeque<>();

        while (!stack.isEmpty()) {
            int num = stack.pop();

            if (!helperStack.isEmpty() && helperStack.peek() > num) {
                while (!helperStack.isEmpty() && helperStack.peek() > num) {
                    stack.push(helperStack.pop());
                }
            }

            helperStack.push(num);
        }

        while (!helperStack.isEmpty()) {
            stack.push(helperStack.pop());
        }
    }


}
