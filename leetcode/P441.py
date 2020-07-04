class Solution:
    def arrangeCoins(self, n: int) -> int:
        if n == 0:
            return 0
        val = None
        for i in range(1, n+1):
            val = (i * (i+1))/2
            if (val > n):
                return i - 1
        return n
