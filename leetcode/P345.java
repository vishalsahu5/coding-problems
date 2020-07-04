class Solution {
  
  private static void swap(char[] s, int i, int j) {
      char temp = s[i];
      s[i] = s[j]; 
      s[j] = temp;
  }
  
  private static boolean isVowel(Character ch) {
      if (ch == 'a' ||
          ch == 'e' ||
          ch == 'i' ||
          ch == 'o' ||
          ch == 'u' ||
          ch == 'A' ||
          ch == 'E' ||
          ch == 'I' ||
          ch == 'O' ||
          ch == 'U') {
          return true;
      }
      return false;
  }
  
  public String reverseVowels(String s) {        
      int start = 0, end = s.length()-1;
      char[] chars = s.toCharArray();
      while (start < end) {
          while (start < s.length() && !isVowel(chars[start])) {
              start++;
          }
          while (end >= 0 && !isVowel(chars[end])) {
              end--;
          }
          if (start >= end) break;
          swap(chars, start, end);
          start++;
          end--;
      }
      return String.valueOf(chars);
  }
}