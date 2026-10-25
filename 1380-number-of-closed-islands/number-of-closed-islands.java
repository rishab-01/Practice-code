class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
       
        for (int r = 0; r < rows; r++) {
            if (grid[r][0] == 0) dfs(grid, r, 0);
            if (grid[r][cols - 1] == 0) dfs(grid, r, cols - 1);
        }
        for (int c = 0; c < cols; c++) {
            if (grid[0][c] == 0) dfs(grid, 0, c);
            if (grid[rows - 1][c] == 0) dfs(grid, rows - 1, c);
        }
        
        
        int closedIslandsCount = 0;
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (grid[r][c] == 0) {
                    closedIslandsCount++;
                    dfs(grid, r, c);
                }
            }
        }
        
        return closedIslandsCount;
    }
    
    private void dfs(int[][] grid, int r, int c) {
        
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 1) {
            return;
        }
       grid[r][c] = 1;
        
       
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}