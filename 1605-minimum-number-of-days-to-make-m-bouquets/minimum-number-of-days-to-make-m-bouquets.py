class Solution:
    def minDays(self, bloomDay: list[int], m: int, k: int) -> int:
        n = len(bloomDay)
        
        if m * k > n:
            return -1
        
        def canMake(day: int) -> bool:
            bouquets = 0
            flowers = 0
            for bloom in bloomDay:
                if bloom <= day:
                    flowers += 1
                    if flowers == k:
                        bouquets += 1
                        flowers = 0
                else:
                    flowers = 0
            return bouquets >= m

        low, high = min(bloomDay), max(bloomDay)
        ans = high
        
        while low <= high:
            mid = (low + high) // 2
            if canMake(mid):
                ans = mid
                high = mid - 1
            else:
                low = mid + 1

        return ans 
        