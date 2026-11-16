import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int n = position.length;
        int low = 1;
        int high = (position[n - 1] - position[0]) / (m - 1);
        int ans = 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canPlace(position, m, mid)) {
                ans = mid;     
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
    
   
    private boolean canPlace(int[] position, int m, int minDist) {
        int ballsPlaced = 1;
        int lastPos = position[0];
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= minDist) {
                ballsPlaced++;
                lastPos = position[i];
                if (ballsPlaced == m) {
                    return true;
                }
            }
        }
        
        return false;
    }
}