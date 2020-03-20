class CustomStack {

  private int[] stack;
  private int currPos;

  public CustomStack(int maxSize) {
    currPos = -1;
    stack = new int[maxSize];
  }

  public void push(int x) {
    if (currPos != stack.length - 1) {
      stack[++currPos] = x;
    }
  }

  public int pop() {
    return currPos == -1 ? currPos : stack[currPos--];
  }

  public void increment(int k, int val) {
    k = Math.min(k - 1, stack.length - 1);
    for (int i = 0; i <= Math.min(k, currPos); i++) {
      stack[i] += val;
    }
  }
}

/**
 * Your CustomStack object will be instantiated and called as such: CustomStack
 * obj = new CustomStack(maxSize); obj.push(x); int param_2 = obj.pop();
 * obj.increment(k,val);
 */