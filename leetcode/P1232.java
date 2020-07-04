class Solution {
    public boolean checkStraightLine(int[][] points) {
        double prevSlope = 0.0;
        for (int i=0; i<points.length-1; i++) {
            int x1 = points[i][0], x2 = points[i+1][0], y1 = points[i][1], y2 = points[i+1][1];
            double slope = x1 != x2 ? (double)(y2 - y1)/(double)(x2 - x1) : (double)Integer.MAX_VALUE;
            if (i == 0) {
                prevSlope = slope;
            }
            if (slope != prevSlope) {
                return false;
            }
        }
        return true;
    }
}