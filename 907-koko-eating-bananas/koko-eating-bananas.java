class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int low = 1;
        int high = 0;
        
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (possible(piles, mid, h)) {
                ans = mid;         
                high = mid - 1;
            } else {
                low = mid + 1;    
            }
        }
        
        return ans;
    }
    
    private boolean possible(int[] piles, int k, int h) {
        long hoursSpent = 0; 
        
        for (int pile : piles) {
       
            hoursSpent += (pile + k - 1) / k;
        }
        
        return hoursSpent <= h;
    }
}
        
    
