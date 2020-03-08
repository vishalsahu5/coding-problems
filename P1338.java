class Solution {
    
  public int minSetSize(int[] arr) {
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i: arr) {
          map.put(i, map.getOrDefault(i, 0)+1);
      }
      for (int key: map.keySet()) {
          pq.add(map.get(key));
      }
      int sum = 0, result = 0;
      while (pq.size() > 0 && sum < arr.length/2) {
          sum += pq.poll();
          result++;
      }
      return result;
  }
}