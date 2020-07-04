class MinStack {
    private class Pair {
        public int first;
        public int second;
        
        public Pair (int first, int second) {
            this.first = first;
            this.second = second;
        }
    };
    Stack<Pair> stack;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.size() == 0 || stack.peek().second > x) {
            stack.push(new Pair(x, x));
        } else {
            stack.push(new Pair(x, stack.peek().second));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().first;
    }
    
    public int getMin() {
       return stack.peek().second; 
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