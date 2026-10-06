import java.util.ArrayList;
import java.util.List;

class Solution {
    public List luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxOfRowMins = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int rowMin = matrix[i][0];
            for (int j = 1; j < n; j++) {
                rowMin = Math.min(rowMin, matrix[i][j]);
            }
            maxOfRowMins = Math.max(maxOfRowMins, rowMin);
        }

        int minOfColMaxs = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            int colMax = matrix[0][j];
            for (int i = 1; i < m; i++) {
                colMax = Math.max(colMax, matrix[i][j]);
            }
            minOfColMaxs = Math.min(minOfColMaxs, colMax);
        }

        List result = new ArrayList<>();
        if (maxOfRowMins == minOfColMaxs) {
            result.add(maxOfRowMins);
        }

        return result;
    }
}
