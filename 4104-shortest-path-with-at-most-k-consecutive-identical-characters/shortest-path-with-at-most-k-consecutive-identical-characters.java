
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u].add(new int[]{v, w});
        }

        
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        
       
        long[][] dist = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

       
        pq.offer(new long[]{0, 0, 1});
        dist[0][1] = 0;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];
            int count = (int) curr[2];

            if (d > dist[u][count]) continue;

            
            if (u == n - 1) {
                return (int) d;
            }

            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int w = neighbor[1];

                int nextCount;
                if (labels.charAt(u) == labels.charAt(v)) {
                    nextCount = count + 1;
                } else {
                    nextCount = 1;
                }

              
                if (nextCount > k) continue;

                if (d + w < dist[v][nextCount]) {
                    dist[v][nextCount] = d + w;
                    pq.offer(new long[]{d + w, v, nextCount});
                }
            }
        }

       
        long ans = Long.MAX_VALUE;
        for (int c = 1; c <= k; c++) {
            ans = Math.min(ans, dist[n - 1][c]);
        }

        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}