class Solution {
  public boolean isHappy(int n) {
    HashMap<Integer, Boolean> m = new HashMap<>();
    m.put(n, true);
    while (n != 1) {
      long sum = 0;
      while (n != 0) {
        sum += (n % 10) * (n % 10);
        n = n / 10;
      }
      n = (int) sum;
      if (m.containsKey(n) == true)
        return false;
      m.put(n, true);
    }
    return true;
  }
}