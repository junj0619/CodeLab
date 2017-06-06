package Class1_MinStack_155;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by junjin on 6/4/17.
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * Accepted Solutions Runtime Distribution
 * Runtime: 119 ms
 * Beats  : 52.00%
 */
public class MinStack {

    /**
     * initialize your data structure here.
     */
    Deque<Integer> dataStack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();
    int min;

    public MinStack() {

    }

    public void push(int x) {
        if (minStack.isEmpty()) {
            minStack.push(x);
            min = x;
        } else {
            /*Use greater and equal than x
            * Because same min value can appear multiple times
            * To keep getMin() always getting correct value after pop() option
            * So each time we push same min to the minStack
            * */
            if (minStack.peek() >= x) {
                minStack.push(x);
                min = x;
            }
        }
        dataStack.push(x);
    }

    public void pop() {
        if (!dataStack.isEmpty()) {
            int num = dataStack.pop();
            if (minStack.peek() == num)
                minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

