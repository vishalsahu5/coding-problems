class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote == null || ransomNote.length() == 0) {
      return true;
    }

    int[] map = new int[256];
    for (int i = 0; i < magazine.length(); i++) {
      map[magazine.charAt(i) - '0']++;
    }

    for (int i = 0; i < ransomNote.length(); i++) {
      if (map[ransomNote.charAt(i) - '0'] > 0) {
        map[ransomNote.charAt(i) - '0']--;
      } else {
        return false;
      }
    }
    return true;
  }
}