def getRange(a, b):
    if b-a <= 1:
        return None
    elif b-a == 2:
        return str(a+1)
    else:
        return str(a+1) + "->" + str(b-1)


class Solution:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[str]:
        result = []
        for i in range(len(nums)-1):
            val = getRange(nums[i], nums[i+1])
            if val is not None:
                result.append(val)

        if (len(nums) > 0 and lower < nums[0]):
            result.insert(0, getRange(lower-1, nums[0]))

        if (len(nums) > 0):
            result.append(getRange(nums[-1], upper+1))

        if (len(nums) == 0):
            result.append(getRange(lower-1, upper+1))

        result = filter(lambda x: x != None, result)
        return result
