class Solution {
    private int count;

    private void util(int[] nums, int S, int idx, int currSum) {
        if (idx == nums.length) {
            if (currSum == S) {
                count++;
            }
            return;
        }

        // take plus sign
        util(nums, S, idx + 1, currSum + nums[idx]);
        // take minus sign
        util(nums, S, idx + 1, currSum - nums[idx]);
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null)
            return 0;

        count = 0;

        util(nums, S, 0, 0);

        return count;
    }
}