class Solution {
  public List<String> commonChars(String[] A) {

    ArrayList<HashMap<Character, Integer>> m = new ArrayList<>();
    for (int i = 0; i < A.length; i++) {
      m.add(new HashMap<>());
    }

    List<String> result = new ArrayList<>();
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length(); j++) {
        m.get(i).put(A[i].charAt(j), m.get(i).getOrDefault(A[i].charAt(j), 0) + 1);
      }
    }

    for (char ch = 'a'; ch <= 'z'; ch++) {
      int minval = m.get(0).getOrDefault(ch, 0);
      for (int i = 1; i < m.size(); i++) {
        minval = Math.min(minval, m.get(i).getOrDefault(ch, 0));
      }
      for (int i = 0; i < minval; i++) {
        result.add(String.valueOf(ch));
      }
    }
    return result;
  }
}