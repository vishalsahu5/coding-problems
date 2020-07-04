class Solution {
  public int firstUniqChar(String s) {
    int[] map = new int[256];
    for (int i = 0; i < s.length(); i++) {
      map[s.charAt(i) - '0']++;
    }

    for (int i = 0; i < s.length(); i++) {
      if (map[s.charAt(i) - '0'] == 1) {
        return i;
      }
    }
    return -1;
  }
}