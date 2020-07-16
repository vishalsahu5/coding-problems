def powUtil(x, n):
    if n == 0 or n == 1:
        return 1 if n is 0 else x
    if n % 2 == 0:
        val = powUtil(x, n//2)
        return val * val
    else:
        val = powUtil(x, n//2)
        return x * val * val


class Solution:
    def myPow(self, x: float, n: int) -> float:
        if x == 1:
            return 1
        if n < 0:
            return 1.00000/(powUtil(x, -n))
        else:
            return powUtil(x, n)
