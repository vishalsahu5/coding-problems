def util(nums, index, subset, result):
    result.append(subset[:])

    for i in range(index, len(nums)):
        if i == index or nums[i] != nums[i-1]:
            subset.append(nums[i])
            util(nums, i+1, subset, result)
            subset.pop()


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        result = []
        util(nums, 0, [], result)
        return result
