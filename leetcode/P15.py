class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        result = []
        resultSet = set()
        for i in range(len(nums)-2):
            j,k = i+1,len(nums)-1
            while (i < j < k):
                val = nums[i] + nums[j] + nums[k]
                if (val == 0):
                    # result.append([nums[i],nums[j],nums[k]])
                    temp = str(nums[i]) + "#" + str(nums[j]) + "#" + str(nums[k])
                    resultSet.add(temp)
                    j += 1
                    k -= 1
                elif (val < 0):
                    j += 1
                elif (val > 0):
                    k -= 1
        for item in resultSet:
            result.append(item.split('#'))
        return result