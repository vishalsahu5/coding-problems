class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = 0
        j = 0
        while True:
            while j < len(nums) and nums[j] == 0:
                j += 1
            while i < len(nums) and nums[i] != 0:
                i += 1
            if i >= len(nums) or j >= len(nums):
                break
            if i > j:
                i, j = j, i
            else:
                nums[i] = nums[j]
                nums[j] = 0
