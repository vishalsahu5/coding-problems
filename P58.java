import java.util.StringTokenizer;

class Solution {
    public int lengthOfLastWord(String str) {
      if (str.length() == 0) {
        return 0;
      }

      StringTokenizer words = new StringTokenizer(str, " ");
      String word = "";
      while (words.hasMoreTokens()) {
        word = words.nextToken();
      }
      return word.length();
    }
}