class MinStack {
    Deque<Integer> dataStack = new ArrayDeque();
    Deque<Integer> minStack = new ArrayDeque();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        dataStack.push(x);
        
        if (minStack.isEmpty() || x <= minStack.peek())        
            minStack.push(x);
    }
    
    public void pop() {        
        if (dataStack.isEmpty()) return;
            
        int num = dataStack.pop();
        
        if (minStack.peek() == num)
            minStack.pop();
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
