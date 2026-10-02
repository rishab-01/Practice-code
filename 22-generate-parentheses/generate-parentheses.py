class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        result=[]
        def backtrack(current_str: str, open_count: int, close_count: int):
            # Base case: if the string length reaches 2 * n
            if len(current_str) == 2 * n:
                result.append(current_str)
                return
            
            # Can add '(' if open count is less than n
            if open_count < n:
                backtrack(current_str + "(", open_count + 1, close_count)
                
            # Can add ')' if close count is less than open count
            if close_count < open_count:
                backtrack(current_str + ")", open_count, close_count + 1)
        
        backtrack("", 0, 0)
        return result
        