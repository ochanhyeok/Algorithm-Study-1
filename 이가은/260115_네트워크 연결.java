import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int a, b, w;
        Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static int[] parent;
    static int[] rank;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return false; 

        // union by rank
        if (rank[ra] < rank[rb]) parent[ra] = rb;
        else if (rank[ra] > rank[rb]) parent[rb] = ra;
        else {
            parent[rb] = ra;
            rank[ra]++;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim()); // 컴퓨터 수
        int M = Integer.parseInt(br.readLine().trim()); // 간선 수

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, w);
        }

        Arrays.sort(edges);

        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        long total = 0;
        int picked = 0;

        for (Edge e : edges) {
            if (union(e.a, e.b)) {
                total += e.w;
                picked++;
                if (picked == N - 1) break;
            }
        }

        System.out.println(total);
    }
}
