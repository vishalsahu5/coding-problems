class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1.0/x;
        
        double result = myPow(x, n/2);
        if (n%2 == 0) {
            return result * result;
        } else {
            if (n > 0)
                return result * result * x;
            else
                return result * result * 1.0/x;
        }
    }
}