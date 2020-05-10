class Solution {
    public int findJudge(int N, int[][] trust) {
        
        int[] incoming = new int[N+1];
        int[] outgoing = new int[N+1];
        for (int i=0; i<trust.length; i++) {
            outgoing[trust[i][0]]++;
            incoming[trust[i][1]]++;
        }
        int count = 0;
        int loc = -1;
        for (int i=1; i<=N; i++) {
            if (outgoing[i] == 0 && incoming[i] == N-1) {
                count++;
                loc = i;
            }
        }
        return count == 1 ? loc : -1;
    }
}