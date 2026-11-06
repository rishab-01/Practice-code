

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        
        
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        
       
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int[] result = new int[m];
        HashMap<Integer, Integer> serverCounts = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int logCount = logs.length;
        
        for (int i = 0; i < m; i++) {
            int queryTime = sortedQueries[i][0];
            int originalIdx = sortedQueries[i][1];
            
            int windowStart = queryTime - x;
            int windowEnd = queryTime;
            
            
            while (right < logCount && logs[right][1] <= windowEnd) {
                int serverId = logs[right][0];
                serverCounts.put(serverId, serverCounts.getOrDefault(serverId, 0) + 1);
                right++;
            }
            
           
            while (left < logCount && logs[left][1] < windowStart) {
                int serverId = logs[left][0];
                int count = serverCounts.get(serverId);
                if (count == 1) {
                    serverCounts.remove(serverId);
                } else {
                    serverCounts.put(serverId, count - 1);
                }
                left++;
            }
            
           
            result[originalIdx] = n - serverCounts.size();
        }
        
        return result;
    }
}