class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] result = new int[nums.length];
        int[] numsCopy = new int[nums.length];
        HashMap<Integer, Integer> loc = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsCopy[i] = nums[i];
        }
        Arrays.sort(numsCopy);
        for (int i = 0; i < nums.length; i++) {
            if (!loc.containsKey(numsCopy[i])) {
                loc.put(numsCopy[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = loc.get(nums[i]);
        }

        return result;
    }
}