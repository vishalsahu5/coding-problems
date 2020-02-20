class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        util(nums, 0, result);
        return result;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void util(int[] nums, int idx, List<List<Integer>> result) {
        if (idx == nums.length-1) {
            List<Integer> l = new ArrayList<>();
            for (int i=0; i<nums.length; i++) {
                l.add(nums[i]);
            }
            result.add(l);
            return;
        }
        for (int i=idx; i<nums.length; i++) {
            swap(nums, i, idx);
            util(nums, idx+1, result);
            swap(nums, i, idx);
        }   
    }
}