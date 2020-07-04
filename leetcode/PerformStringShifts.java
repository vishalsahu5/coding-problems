class Solution {
  public String stringShift(String s, int[][] shift) {
    int count = 0;
    for (int i = 0; i < shift.length; i++) {
      if (shift[i][0] == 1) {
        count += shift[i][1];
      } else {
        count -= shift[i][1];
      }
    }
    count = count % s.length();
    if (count < 0)
      count += s.length();
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < s.length(); i++) {
      int pos = (i + count) % s.length();
      sb.setCharAt(pos, s.charAt(i));
    }
    return sb.toString();
  }
}