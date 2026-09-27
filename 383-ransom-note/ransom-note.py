from collections import Counter
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:

        frequency = Counter(magazine)

        for char in ransomNote:
            if frequency[char]<=0:
                return False

            frequency[char] -= 1

        return True

        