class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        def countSetBits(n):
            if (n == 0):
                return 0
            else:
                return (n & 1) + countSetBits(n >> 1)

        z = x ^ y
        return countSetBits(z)
