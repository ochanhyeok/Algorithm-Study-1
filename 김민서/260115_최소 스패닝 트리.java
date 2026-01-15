import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int from, to, cost;

    Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {

    static int N, M;
    static int[] parent;
    static Edge[] edges;

    // find : 대표 노드 찾기
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    // union : 두 집합 합치기
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점
        N = Integer.parseInt(st.nextToken());

        // 간선
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        // 비용 기준 오름차순 정렬
        Arrays.sort(edges);

        // Union-Find 초기화
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i; // 처음엔 자기 자신이 대표
        }

        int totalCost = 0;
        int edgeCount = 0;

        for (Edge e : edges) {
            // 사이클 검사
            if (find(e.from) != find(e.to)) {
                union(e.from, e.to);      // 연결
                totalCost += e.cost;      // 비용 누적
                edgeCount++;              // 사용한 간선 수 증가

                // MST 완성 조건
                if (edgeCount == N - 1) break;
            }
        }
        
        System.out.println(totalCost);
    }
}
