class Solution {
  private List<String> result;

  private void util(StringBuilder sb, int pos) {
    if (pos == sb.length()) {
      result.add(sb.toString());
      return;
    }
    util(sb, pos + 1);
    if (Character.isDigit(sb.charAt(pos))) {
      return;
    }
    if (Character.isLowerCase(sb.charAt(pos))) {
      sb.setCharAt(pos, Character.toUpperCase(sb.charAt(pos)));
      util(sb, pos + 1);
      sb.setCharAt(pos, Character.toLowerCase(sb.charAt(pos)));
    } else {
      sb.setCharAt(pos, Character.toLowerCase(sb.charAt(pos)));
      util(sb, pos + 1);
      sb.setCharAt(pos, Character.toUpperCase(sb.charAt(pos)));
    }
  }

  public List<String> letterCasePermutation(String S) {
    result = new ArrayList<>();
    util(new StringBuilder(S), 0);
    return result;
  }
}