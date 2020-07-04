class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        if (groupSizes == null || groupSizes.length == 0) return new ArrayList<>();
        
        HashMap<Integer, ArrayList<Integer>> sizeToList = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list;
        for (int i=0; i<groupSizes.length; i++) {
            if (sizeToList.containsKey(groupSizes[i])) {
                list = sizeToList.get(groupSizes[i]);
                list.add(i);
            } else {
                list = new ArrayList<>();
                list.add(i);
                sizeToList.put(groupSizes[i], list);
            }
            if (list.size() == groupSizes[i]) {
                result.add(new ArrayList(list));
                list = new ArrayList<>();
                sizeToList.put(groupSizes[i], list);
            }
            // System.out.println(result);
            // System.out.println(list);
        }
        return result;
    }
}