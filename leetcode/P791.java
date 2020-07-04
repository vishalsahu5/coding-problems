class Solution {
  public String customSortString(String S, String T) {

    HashMap<Character, Integer> m = new HashMap<>();
    for (int i = 0; i < S.length(); i++) {
      m.put(S.charAt(i), i);
    }

    Character tempArray[] = new Character[T.length()];
    for (int i = 0; i < T.length(); i++) {
      tempArray[i] = T.charAt(i);
    }

    Arrays.sort(tempArray, new Comparator<Character>() {

      @Override
      public int compare(Character c1, Character c2) {
        return m.getOrDefault(c1, 0) - m.getOrDefault(c2, 0);
      }
    });

    StringBuilder sb = new StringBuilder(tempArray.length);
    for (Character c : tempArray)
      sb.append(c.charValue());

    return sb.toString();
  }
}