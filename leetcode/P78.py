def solve(nums, index, subset, result):
    if index == len(nums):
        result.append(subset[:])
        return
    subset.append(nums[index])
    solve(nums, index+1, subset, result)
    subset.pop()
    solve(nums, index+1, subset, result)


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # nums.sort()
        result = []
        solve(nums, 0, [], result)
        return result
