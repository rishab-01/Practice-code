from collections import Counter

class Solution:
    def longestPalindrome(self, s):
        frequency = Counter(s)

        total = 0
        has_odd = False

        for freq in frequency.values():
            if freq % 2 == 0:
                total += freq
            else:
                total += freq - 1
                has_odd = True

        if has_odd:
            total += 1

        return total
        