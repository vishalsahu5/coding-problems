class Solution {
  int[] map;

  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length())
      return false;
    int left = 0, right = 0;
    map = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      map[s1.charAt(i) - 'a']++;
    }
    while (right < s1.length()) {
      map[s2.charAt(right) - 'a']--;
      right++;
    }
    if (isAllZero())
      return true;
    left = 0;
    while (right < s2.length()) {
      map[s2.charAt(right) - 'a']--;
      map[s2.charAt(left) - 'a']++;
      right++;
      left++;
      if (isAllZero()) {
        return true;
      }
    }
    return false;
  }

  private boolean isAllZero() {
    for (char ch = 'a'; ch <= 'z'; ch++) {
      if (map[ch - 'a'] != 0)
        return false;
    }
    return true;
  }
}