import java.io.*;
import java.util.*;

 /* 핵심 아이디어:
 * 1) 간선을 비용 오름차순으로 정렬
 * 2) 비용이 작은 간선부터 보면서 "사이클이 생기지 않으면" 선택
 * 3) 간선을 (N-1)개 선택하면 MST 완성, 그 비용 합이 정답
 */
public class Main {

    /** 간선 정보(컴퓨터 a, b를 비용 c로 연결) */
    static class Edge {
        int a, b, cost;
        Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    // Union-Find 자료구조용 배열
    static int[] parent; // parent[x] = x가 속한 집합의 대표(루트)
    static int[] rank;   // rank[x] = 트리 높이(대략), union 시 균형 유지용

    /**
     * find(x): x가 속한 집합의 대표(루트)를 찾음
     * - path compression(경로 압축)을 적용하여 매우 빠르게 만듦
     */
    static int find(int x) {
        if (parent[x] == x) return x;          // 자기 자신이 대표면 그대로 반환
        parent[x] = find(parent[x]);           // 경로 압축: 부모를 대표로 바로 연결
        return parent[x];
    }

    /**
     * union(a, b): a가 속한 집합과 b가 속한 집합을 합칩니다.
     * - 이미 같은 집합이면(= 이미 연결돼 있으면) false (사이클 발생)
     * - 합쳤으면 true
     */
    static boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if (ra == rb) return false; // 이미 같은 집합 -> 이 간선을 추가하면 사이클

        // union by rank: 더 낮은 트리를 더 높은 트리에 붙여 균형 유지
        if (rank[ra] < rank[rb]) {
            parent[ra] = rb;
        } else if (rank[ra] > rank[rb]) {
            parent[rb] = ra;
        } else {
            parent[rb] = ra;
            rank[ra]++; // 높이가 같으면 대표 쪽 rank 증가
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N: 컴퓨터(정점) 개수, M: 연결 정보(간선) 개수
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());

        // 모든 간선을 저장
        Edge[] edges = new Edge[M];

        // 간선 입력: a b c (a와 b를 비용 c로 연결)
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        // 1) 비용(cost) 오름차순 정렬 (Kruskal의 시작)
        Arrays.sort(edges, Comparator.comparingInt(e -> e.cost));

        // Union-Find 초기화: 처음엔 각 정점이 자기 자신이 대표(서로 분리)
        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        long answer = 0;      // MST 총 비용 합 (안전하게 long)
        int picked = 0;       // MST에 포함된 간선 수

        // 2) 작은 비용 간선부터 하나씩 보며, 사이클이 안 생기면 선택
        for (Edge e : edges) {
            // e.a 와 e.b가 아직 다른 집합이면 연결(선택) 가능
            if (union(e.a, e.b)) {
                answer += e.cost; // 비용 누적
                picked++;         // 선택 간선 수 증가

                // MST는 정점 N개일 때 간선이 N-1개면 완성
                if (picked == N - 1) break;
            }
            // union이 false면: 이미 연결된 집합 -> 이 간선은 버림(사이클 방지)
        }

        // 3) MST 비용 출력
        System.out.println(answer);
    }
}
