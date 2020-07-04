class Solution {
    private static ArrayList<LinkedList<Integer>> m;
    
    private void solve(int[] A, int target, int pos, LinkedList<Integer> l) {
        if (target < 0) {
            return;
        }
        if (pos == A.length) {
            // System.out.println(m.contains(l));
            if (target == 0 && !m.contains(l)) {
                m.add(l);
            }
            return;
        }
        
        
        solve(A, target, pos+1, new LinkedList<>(l));
        l.add(A[pos]);
        solve(A, target - A[pos], pos+1, new LinkedList<>(l));
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        m = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        LinkedList<Integer> temp = new LinkedList<Integer>();
        solve(candidates, target, 0, temp);
        List<List<Integer>> result = new ArrayList<>();
        // System.out.println(m);
        for (List<Integer> l : m) {
            result.add(l);
        }
        
        return result;
    }
}