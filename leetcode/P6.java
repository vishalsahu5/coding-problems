class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1)
      return s;
    int letters = 0;
    int cols = 0;
    boolean flag = false;
    while (letters < s.length()) {
      if (!flag) {
        letters += Math.min(numRows, s.length() - letters);
        cols++;
      } else {
        letters += Math.min(numRows - 2, s.length() - letters);
        cols += numRows - 2;
      }
      flag = !flag;
    }
    char[][] matrix = new char[numRows][cols];
    flag = false;
    letters = 0;
    int i = 0, j = 0;
    while (letters < s.length() && j < cols) {
      if (!flag) {
        while (i < numRows && j < cols && letters < s.length()) {
          matrix[i++][j] = s.charAt(letters++);
        }
        i -= 2;
        j++;
        flag = !flag;
      } else {
        while (i > 0 && j < cols && letters < s.length()) {
          matrix[i][j] = s.charAt(letters++);
          i--;
          j++;
        }
        flag = !flag;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (i = 0; i < numRows; i++) {
      for (char ch : matrix[i]) {
        if ((int) ch != 0)
          sb.append(ch);
      }
    }
    return sb.toString();
  }
}