class Solution {
    private boolean[] visited;
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        visited = new boolean[nums.length];
        // util(nums, 0, result);
        dfs(nums, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void dfs(int[] nums, ArrayList<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(list);
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, new ArrayList<>(list), result);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
    
//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
//     
//     private void util(int[] nums, int idx, List<List<Integer>> result) {
//         if (idx == nums.length-1) {
//             List<Integer> l = new ArrayList<>();
//             for (int i=0; i<nums.length; i++) {
//                 l.add(nums[i]);
//             }
//             result.add(l);
//             return;
//         }
//         for (int i=idx; i<nums.length; i++) {
//             swap(nums, i, idx);
//             util(nums, idx+1, result);
//             swap(nums, i, idx);
//         }
//     }
}