class Solution {
  private ArrayList<String> result;

  public void util(int open, int close, StringBuilder formationSb) {
    if (close == 0) {
      result.add(formationSb.toString());
      return;
    }

    if (open > 0) {
      formationSb.append("(");
      util(open - 1, close, formationSb);
      formationSb.deleteCharAt(formationSb.length() - 1);
    }
    if (open < close) {
      formationSb.append(")");
      util(open, close - 1, formationSb);
      formationSb.deleteCharAt(formationSb.length() - 1);
    }
  }

  public List<String> generateParenthesis(int n) {
    result = new ArrayList<>();
    if (n == 0)
      return new ArrayList<>();

    int open = n, close = n;
    util(open, close, new StringBuilder());
    return result;
  }
}