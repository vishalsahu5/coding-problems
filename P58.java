class Solution {
  public int lengthOfLastWord(String str) {
    if (str.length() == 0) {
        return 0;
    }
    
    int start = 0;
    int end = str.length()-1;
    
    while (end >= 0 && end >= start && str.charAt(end) == ' ') {
        end--;
    }
    start = end;
    while (start >= 0 && str.charAt(start) != ' ') {
        start--;
    }
    return end - start;
}
}