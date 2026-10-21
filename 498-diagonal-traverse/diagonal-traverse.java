class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        
        int r = 0, c = 0;
        int direction = 1; 
        
        for (int i = 0; i < m * n; i++) {
            result[i] = mat[r][c];
            
            if (direction == 1) {
                
                if (c == n - 1) {
                    r++;          
                    direction = -1;
                } else if (r == 0) {
                    c++;          
                    direction = -1;
                } else {
                    r--;
                    c++;
                }
            } else {
                
                if (r == m - 1) {
                    c++;          
                    direction = 1;
                } else if (c == 0) {
                    r++;          
                    direction = 1;
                } else {
                    r++;
                    c--;
                }
            }
        }
        
        return result;
    }
}