from collections import Counter
class Solution:
    def firstUniqChar(self, s: str) -> int:
        
        frequency = Counter(s)

        for i in range(len(s)):
            if frequency[s[i]] == 1:
                return i

        return -1
        