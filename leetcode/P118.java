class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (numRows == 0) return ans;
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        ans.add(list);
        for (int i=1; i<numRows; i++) {
            list = new ArrayList<Integer>(Collections.nCopies(i+1, 1)); 
            for (int j=1; j<=ans.get(i-1).size()-1; j++) {
                list.set(j, ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            ans.add(list);
        }
        return ans;
    }
}