from collections import Counter
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        len(s)
        len(t)
        
        if len(s) != len(t):
            return False
        frequency_s = Counter(s)
        frequency_t = Counter(t)

        return frequency_s == frequency_t


        