class Solution {

  private String prepend(String s, int zeros) {
    StringBuilder sb = new StringBuilder(s);
    sb = sb.reverse();
    for (int i = 0; i < zeros; i++) {
      sb.append('0');
    }
    return sb.reverse().toString();
  }

  public String addBinary(String a, String b) {
    if (b.length() > a.length())
      return addBinary(b, a);

    b = prepend(b, a.length() - b.length());

    char carry = '0';
    StringBuilder result = new StringBuilder();
    for (int i = b.length() - 1; i >= 0; i--) {
      char bit1 = a.charAt(i);
      char bit2 = b.charAt(i);
      if (bit1 == '0' && bit2 == '0' && carry == '0') {
        result.append('0');
        carry = '0';
      } else if (bit1 == '1' && bit2 == '1' && carry == '1') {
        result.append('1');
        carry = '1';
      } else if (bit1 == '0' && bit2 == '0' && carry == '1') {
        result.append('1');
        carry = '0';
      } else if (bit1 == '1' && bit2 == '0' && carry == '0') {
        result.append('1');
      } else if (bit1 == '0' && bit2 == '1' && carry == '0') {
        result.append('1');
        carry = '0';
      } else {
        result.append('0');
        carry = '1';
      }
    }
    if (carry == '1')
      result.append('1');
    return result.reverse().toString();
  }
}