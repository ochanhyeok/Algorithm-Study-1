import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int a;      
    int b;      
    int cost;  
    
    Edge(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }
    
    // 비용 기준 오름차순 정렬
    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}

public class Main {
    static int[] parent;
    
    // 루트 노드 찾기
    public static int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }
    
    // 두 집합 합치기
    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        
        //더 작은 애를 부모로 
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());  // 컴퓨터 개수
        int m = Integer.parseInt(br.readLine());  // 연결선 개수
        
        // 부모 배열 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        // 간선 정보 입력
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, cost));
        }
        
        // 비용 기준 정렬
        Collections.sort(edges);
        
        // 크루스칼 알고리즘
        int result = 0;
        
        for (Edge edge : edges) {
            // 사이클이 발생하지 않으면 선택
            if (findParent(edge.a) != findParent(edge.b)) {
                union(edge.a, edge.b);
                result += edge.cost;
            }
        }
        
        System.out.println(result);
    }
}