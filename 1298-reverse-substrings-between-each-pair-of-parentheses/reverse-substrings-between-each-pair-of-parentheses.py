class Solution:
    def reverseParentheses(self, s: str) -> str:
        
    
        stack = []
        current = ""

        for char in s:
            if char == '(':
                stack.append(current)
                current = ""

            elif char == ')':
                current = current[::-1]
                current = stack.pop() + current

            else:
                current += char

        return current
        