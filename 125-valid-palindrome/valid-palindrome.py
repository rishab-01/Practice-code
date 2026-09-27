class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()

        cleaned = ""

        for char in s:
            if char.isalnum():
                cleaned += char

        return cleaned == cleaned[::-1]