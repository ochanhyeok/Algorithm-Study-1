import java.io.*;
import java.util.*;

public class Main {

    /* 간선 정보를 담는 클래스 */
    static class Edge {
        int u;  // 한쪽 정점
        int v;  // 다른 쪽 정점
        int w;  // 가중치

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    /* Union-Find (Disjoint Set) */
    static int[] parent; // parent[x] : x가 속한 집합의 대표
    static int[] rank;   // rank[x]   : 트리 높이(균형 유지용)

    // x가 속한 집합의 대표(root)를 찾는 함수
    static int find(int x) {
        // parent[x] == x 이면 x가 대표
        if (parent[x] == x) return x;

        // 경로 압축(Path Compression)
        // x의 부모를 대표로 바로 연결
        parent[x] = find(parent[x]);
        return parent[x];
    }

    // 두 집합을 합치는 함수
    // 합쳐졌으면 true, 이미 같은 집합이면 false
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // 이미 같은 집합이면 사이클 발생
        if (rootA == rootB) return false;

        // rank를 이용해 더 낮은 트리를 높은 트리에 붙임
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++; // 높이가 같으면 하나 증가
        }

        return true; // 정상적으로 합쳐짐
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점(V), 간선(E) 개수 입력
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 모든 간선을 저장할 배열
        Edge[] edges = new Edge[E];

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        // Kruskal 핵심 1:
        // 간선을 가중치 기준 오름차순 정렬
        Arrays.sort(edges, Comparator.comparingInt(e -> e.w));

        // Union-Find 초기화
        parent = new int[V + 1];
        rank = new int[V + 1];

        // 처음에는 모든 정점이 자기 자신이 대표
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        long totalWeight = 0; // MST 전체 가중치 합
        int edgeCount = 0;    // 선택된 간선 수

        // Kruskal 핵심 2:
        // 가장 가중치가 작은 간선부터 하나씩 확인
        for (Edge e : edges) {

            // 이 간선을 추가해도 사이클이 생기지 않는다면
            if (union(e.u, e.v)) {
                totalWeight += e.w; // 가중치 누적
                edgeCount++;        // 간선 개수 증가
            }

            // MST는 간선이 V-1개면 완성
            if (edgeCount == V - 1) break;
        }

        // 최소 스패닝 트리의 총 가중치 출력
        System.out.println(totalWeight);
    }
}
