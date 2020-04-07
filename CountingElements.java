class Solution {
  public int countElements(int[] arr) {
    HashMap<Integer, Integer> count = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
    }
    int result = 0;
    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
      int key = entry.getKey();
      if (count.containsKey(key - 1)) {
        result += count.get(key - 1);
      }
    }
    return result;
  }
}