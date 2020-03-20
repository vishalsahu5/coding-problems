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
        if (points == null || points.length == 0) return null;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node o1, Node o2) {
                return (int) (o1.dist - o2.dist);
            }
        });
        for (int i = 0; i < points.length; i++) {
            pq.offer(new Node((points[i][0]*points[i][0]) + (points[i][1] * points[i][1]), points[i][0], points[i][1] ));
        }
        int[][] result = new int[K][];
        int j = 0;
        while (j < K) {
            Node temp = pq.poll();
            result[j] = new int[] {temp.x, temp.y};
            j++;
        }
        return result;
    }
}