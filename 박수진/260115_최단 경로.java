import java.io.*;
import java.util.*;


class Main {
    
    // 한 정점에서 갈 수 있는 간선 하나를 표현
    static class Edge {
        int to; // 도착 정점
        int w;  // 가중치
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
    
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점 수
        int E = Integer.parseInt(st.nextToken()); // 간선 수 
        
        int K = Integer.parseInt(br.readLine()); // 시작 정점
        
        // 1) 그래프 : 인접 리스트
        ArrayList<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>(); // 초기화
        }
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w)); // 방향 그래프 (u->v, 가중치 w)
        }
        
        // 2) 최단거리 테이블 : K에서 x까지의 최단거리
        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[K] = 0;
        
        // 3) 우선순위 큐 : {정점번호, 현재까지 거리}
        // 시작점 K부터 어떤 정점(target)까지의 현재까지 알려진 거리와, 그 정점 번호가 pair로 들어감
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{K, 0});
        
        // 4) 다익스트라 실행
        while (!pq.isEmpty()) {
            int[] cur = pq.poll(); // pq에서 거리가 가장 가까운 후보를 꺼냄
            int node = cur[0]; // 현재 처리할 정점
            int d = cur[1];    // 그 정점까지의 거리
            
            // 현재 poll된 거리 d != 최신 최단거리 dist[node]
            if (d != dist[node])
                continue; // d는 구식 정보
            
            // 인접 정점 거리 갱신
            for (Edge e : graph[node]) {
                int next = e.to;
                int nd = d + e.w; // node->next 간선을 따라 갈 때 새로운 거리 계산 (nd)
                
                if (nd < dist[next]) { // 짧은 길 발견
                    dist[next] = nd;   // 갱신
                    pq.add(new int[]{next, nd}); 
                }
            }
        }
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF)
                sb.append("INF\n");
            else
                sb.append(dist[i]).append('\n');
        }
        System.out.print(sb.toString());
    }
}