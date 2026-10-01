class Solution:
    def isValid(self, s: str) -> bool:
        if len(s)%2!=0:
            return False
        stack=[]
        mapping={')':'(','}':'{',']':'['}
        for char in s:
            if char in mapping:
                top_element=stack.pop() if stack else '#'
                if mapping[char]!= top_element:
                    return False
            else:
                stack.append(char)
        return len(stack)==0

        