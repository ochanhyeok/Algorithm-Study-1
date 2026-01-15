import java.util.*;

class Solution {
    
    static class Edge {
        int to, w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        // 1) 인접 리스트 그래프
        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            int a = r[0], b = r[1], w = r[2];
            graph[a].add(new Edge(b, w));
            graph[b].add(new Edge(a, w));
        }
        
        // 2) 다익스트라 준비
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[N+1]; // 1번 마을에서 i번 마을까지의 "현재까지 알고 있는 최단거리"
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        pq.add(new int[]{1, 0}); // {정점, 현재까지 거리}
        
        // 3) 다익스트라
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int d = cur[1];
            
            // 구식 후보 제거
            if (d != dist[node])
                continue;
            
            for (Edge e : graph[node]) {
                int next = e.to;
                int nd = d + e.w;
                
                if (nd < dist[next]) {
                    dist[next] = nd;
                    pq.add(new int[]{next, nd});
                }
            }
        }
        
        // 4) K 이하인 마을 수 카운팅
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) 
                count++;
        }
        return count;
    }
}