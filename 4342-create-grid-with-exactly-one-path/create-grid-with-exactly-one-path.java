class Solution {
    public String[] createGrid(int m, int n) {
        StringBuilder[] rows = new StringBuilder[m];
        
        
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('#');
            }
            rows[i] = sb;
        }
        
      
        for (int j = 0; j < n; j++) {
            rows[0].setCharAt(j, '.');
        }
        
       
        for (int i = 0; i < m; i++) {
            rows[i].setCharAt(n - 1, '.');
        }
        
        
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = rows[i].toString();
        }
        
        return result;
    }
}