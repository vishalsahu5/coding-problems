class Solution {
  public int lastStoneWeight(int[] stones) {
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
          public int compare(Integer o1, Integer o2) {
              return o2.compareTo(o1);
          }
      }); 
      
      for (int i=0; i<stones.length; i++) {
          pq.add(stones[i]);
      }
      
      while (pq.size() > 1) {
          
          int rock1 = pq.poll();
          int rock2 = pq.poll();
          if (rock1 != rock2) {
              pq.add(Math.abs(rock1-rock2));
          }
      }
      
      return pq.size() == 0 ? 0 : pq.poll();
  }
}