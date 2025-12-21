import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int v;      // 노드 번호
        int cost;   // 누적 비용

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 비용 기준 오름차순
        }
    }

    static final int INF = (int)1e9;
    static int n, m;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 도시 수
        m = Integer.parseInt(br.readLine()); // 버스 수

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int dep = Integer.parseInt(st.nextToken());
            int arr = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[dep].add(new Node(arr, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        if (dist[end] == INF) {
            System.out.println("INFINITY");
        } else {
            System.out.println(dist[end]);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.v;
            int distance = cur.cost;

            // 이미 더 짧은 거리로 방문한 적 있으면 스킵
            if (dist[now] < distance) continue;

            // 인접 노드 탐색
            for (Node next : graph[now]) {
                int cost = distance + next.cost;
                if (dist[next.v] > cost) {
                    dist[next.v] = cost;
                    pq.offer(new Node(next.v, cost));
                }
            }
        }
    }
}