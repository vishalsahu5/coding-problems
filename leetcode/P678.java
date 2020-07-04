class Solution {
  public boolean checkValidString(String s) {
    Stack<Integer> stackOpen = new Stack<>();
    Stack<Integer> stackStar = new Stack<>();
    int i = 0;
    int countStar = 0;
    while (i < s.length()) {
      if (s.charAt(i) == '(') {
        stackOpen.push(i);
      } else if (s.charAt(i) == '*') {
        countStar++;
        stackStar.push(i);
      } else {
        if (stackOpen.size() > 0) {
          stackOpen.pop();
        } else if (countStar > 0) {
          countStar--;
          stackStar.pop();
        } else {
          return false;
        }
      }
      i++;
    }
    while (stackOpen.size() > 0 && stackOpen.size() <= stackStar.size()) {
      int openPos = stackOpen.pop();
      int starPos = stackStar.pop();
      if (openPos > starPos) {
        return false;
      }
    }
    return stackOpen.size() == 0;
  }
}