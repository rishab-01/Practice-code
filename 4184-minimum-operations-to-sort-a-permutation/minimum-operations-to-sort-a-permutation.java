
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

       
        int incShift = -1, decShift = -1;
        
        
        for (int i = 0; i < n; i++) {
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (nums[(i + j) % n] != j) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                incShift = i;
                break;
            }
        }

        
        for (int i = 0; i < n; i++) {
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (nums[(i + j) % n] != n - 1 - j) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                decShift = i;
                break;
            }
        }

        if (incShift == -1 && decShift == -1) {
            return -1;
        }

        
        int targetState = 0; 
        
        Queue<long[]> queue = new ArrayDeque<>();
        int[][] dist = new int[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = -1;
            }
        }

       
        int startType = -1, startShift = -1;
        for (int t = 0; t < 2; t++) {
            for (int s = 0; s < n; s++) {
                boolean match = true;
                for (int j = 0; j < n; j++) {
                    int val;
                    if (t == 0) {
                        val = (s + j) % n;
                    } else {
                        val = n - 1 - ((s + j) % n);
                    }
                    if (nums[j] != val) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    startType = t;
                    startShift = s;
                    break;
                }
            }
            if (startType != -1) break;
        }

        if (startType == -1) return -1;

        queue.add(new long[]{startType, startShift});
        dist[startType][startShift] = 0;

        while (!queue.isEmpty()) {
            long[] curr = queue.poll();
            int t = (int) curr[0];
            int s = (int) curr[1];
            int d = dist[t][s];

            if (t == 0 && s == 0) {
                return d;
            }

           
            int nextT1 = t;
            int nextS1 = (s + 1) % n;
            if (dist[nextT1][nextS1] == -1) {
                dist[nextT1][nextS1] = d + 1;
                queue.add(new long[]{nextT1, nextS1});
            }

            int nextT2 = 1 - t;
            int nextS2 = (n - s) % n;
            if (dist[nextT2][nextS2] == -1) {
                dist[nextT2][nextS2] = d + 1;
                queue.add(new long[]{nextT2, nextS2});
            }
        }

        return -1;
    }
}