class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        words = s.strip().split()
        if len(words) == 0:
            return 0
        return len(words[-1])
        