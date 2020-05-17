class Solution {

  public List<Integer> findAnagrams(String s, String p) {
    if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
      return new ArrayList<Integer>();
    }
    List<Integer> res = new ArrayList<Integer>();

    int[] map = new int[256];
    for (char ch : p.toCharArray()) {
      map[ch]++;
    }

    int start = 0, end = 0, diff = p.length();
    for (end = 0; end < p.length(); end++) {
      map[s.charAt(end)]--;
      if (map[s.charAt(end)] >= 0) {
        diff--;
      }
    }
    if (diff == 0) {
      res.add(0);
    }

    while (end < s.length()) {

      if (map[s.charAt(start)] >= 0) {
        diff++;
      }

      map[s.charAt(start)]++;

      start++;

      map[s.charAt(end)]--;
      if (map[s.charAt(end)] >= 0) {
        diff--;
      }
      if (diff == 0) {
        res.add(start);
      }
      end++;
    }

    return res;
  }
}