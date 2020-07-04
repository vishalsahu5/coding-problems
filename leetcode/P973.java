class Solution {
  private class Node {
    public long dist;
    public int x;
    public int y;

    public Node(long dist, int x, int y) {
      this.dist = dist;
      this.x = x;
      this.y = y;
    }
  }

  public int[][] kClosest(int[][] points, int K) {
    if (points == null || points.length == 0)
      return null;
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> (int) (o2.dist - o1.dist));
    for (int i = 0; i < points.length; i++) {
      long d = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
      if (pq.size() < K) {
        pq.offer(new Node(d, points[i][0], points[i][1]));
      } else {
        if (pq.peek().dist > d) {
          pq.poll();
          pq.offer(new Node(d, points[i][0], points[i][1]));
        }
      }
    }
    int[][] result = new int[K][];
    int j = 0;
    while (j < K) {
      Node temp = pq.poll();
      result[j] = new int[] { temp.x, temp.y };
      j++;
    }
    return result;
  }
}