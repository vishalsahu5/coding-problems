class Solution {
    
  public int minSetSize(int[] arr) {
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      Arrays.sort(arr);
      int count = 1, prev = arr[0];
      for (int i=1; i < arr.length; i++) {
          if (arr[i] != prev) {
              pq.add(count);
              count = 1;
              prev = arr[i];
          } else {
              count++;
          }
      }
      if (count > 1) pq.add(count);
      int sum = 0, result = 0;
      while (pq.size() > 0 && sum < arr.length/2) {
          sum += pq.poll();
          result++;
      }
      return result;
  }
}