import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class 최소비용구하기 {

    static class Node implements Comparable<Node> {
        int to; // 지금 보고있는 정점
        int cost; // 시작점에서 to까지의 총 비용

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시의 개수, 버스의 개수
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 그래프 초기화
        List<Node>[] graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        // 출발지, 도착지, 비용
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            // 코스트가 가장 작은 노드부터 poll해서 처리
            Node cur = pq.poll();
            int now = cur.to;
            int nowCost = cur.cost;

            if (nowCost > dist[now]) {
                continue;
            }

            // now에서 갈 수 있는 도시들을 전부 탐색
            for (Node next : graph[now]) {
                int nextCity = next.to;
                int nextCost = nowCost + next.cost;

                if (nextCost < dist[nextCity]) {
                    dist[nextCity] = nextCost;
                    pq.offer(new Node(nextCity, nextCost));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
