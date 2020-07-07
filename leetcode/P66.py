class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        carry, result = 1, 0
        digits.reverse()
        for i in range(len(digits)):
            result = carry + digits[i]
            carry = result//10
            digits[i] = result % 10
        if carry != 0:
            digits.append(carry)
        digits.reverse()
        return digits
