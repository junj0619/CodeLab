import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class SortStack {
    public static void main(String[] args) {
       //sort stack to ascending order.

        Deque<Integer> stack = new ArrayDeque<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int randomNumber = rand.nextInt(10);
            System.out.print(randomNumber + ", ");
            stack.push(randomNumber);
        }

        sortStack(stack);
        System.out.println();
        while (!stack.isEmpty())
            System.out.print(stack.pop() + ", ");

    }

    private static void sortStack(Deque<Integer> stack) {
        if (stack == null || stack.size() == 0) return;

        Deque<Integer> supportStack = new ArrayDeque<>();

        int cur = 0;

        while (!stack.isEmpty()) {
            cur = stack.pop();

            if (supportStack.isEmpty())
                supportStack.push(cur);
            else {
                if (supportStack.peek() >= cur)
                    supportStack.push(cur);
                else {
                    while (!supportStack.isEmpty() && supportStack.peek() < cur) {
                        stack.push(supportStack.pop());
                    }
                    supportStack.push(cur);
                }
            }
        }

        while (!supportStack.isEmpty()) {
            stack.push(supportStack.pop());
        }
    }
}
