class Solution {
    public int repeatedStringMatch(String A, String B) {
        int x = 1;
        StringBuilder sb = new StringBuilder(A);
        for (; sb.length() < B.length(); x++) {
            sb.append(A);
        }
        if (sb.indexOf(B) >= 0) return x;
        if (sb.append(A).indexOf(B) >= 0) return x+1;
        
        return -1;
    }
}