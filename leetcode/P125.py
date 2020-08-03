class Solution:
    def isPalindrome(self, s: str) -> bool:
        clean_string = "".join([letter.lower()
                                for letter in s if letter.isalnum() == True])
        return clean_string == clean_string[::-1]
