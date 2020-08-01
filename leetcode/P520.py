import string


class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        firstCapital = False
        capitals = 0

        for i in range(len(word)):
            if word[i].isupper():
                if i == 0:
                    firstCapital = True
                capitals += 1
        if (capitals == len(word)) or capitals == 0:
            return True
        elif (firstCapital == True and capitals == 1):
            return True
        else:
            return False
