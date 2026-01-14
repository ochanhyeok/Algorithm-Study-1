import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int a;      // 시작
    int b;      // 끝
    int cost;   // 간선 가중치
    
    Edge(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }
    
    // 가중치 기준 오름차순 정렬
    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}

public class Main {
    static int[] parent;  // 부모 노드 배열
    
    //현재 원소의 부모를 찾고, 이를 경로 상의 모든 노드를 부모에 직접 연결
    //이걸 함으로써 다음 번 탐색에서 시간이 줄어듬
    public static int findParent(int x) {
        if (parent[x] != x) {    //현재가 부모노드가 아닌 경우에만
            parent[x] = findParent(parent[x]);  // 재귀로 부모노드 찾아 배열에 설정
        }
        return parent[x];
    }
    
    // 두 노드 집합 합치기 -> 즉 부모 설정해서 한 트리로
    public static void union(int a, int b) {
        a = findParent(a);    //a는 a의 부모
        b = findParent(b);    //n는 b의 부모 
        
        // 더 작은 번호를 전체 트리의 부모노드로 만듦
        if (a > b) {
            parent[a] = b; 
        } else {
            parent[b] = a;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int v = Integer.parseInt(st.nextToken());  // 정점 개수
        int m = Integer.parseInt(st.nextToken());  // 간선 개수
        
        // 부모 배열 초기화->처음엔 자기 자신을 부모로
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
        
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, cost));
        }
        
        // 가중치 기준으로 간선들을 오름차순 정렬
        Collections.sort(edges);
        
        int result = 0;  // 최소 비용
        //간선 탐색하면서 
        for (Edge edge : edges) {
            int a = edge.a;
            int b = edge.b;
            int cost = edge.cost;
            
            // 사이클이 발생하지 않는 경우만 선택 => 두 노드의 부모가 같으면 X
            //두 노드의 부모가 달라야 아직 연결 안 된 거 
            if (findParent(a) != findParent(b)) {
                union(a, b);      // 두 집합 합치기
                result += cost;   // 간선 가중치 추가
            }
        }
        
        System.out.println(result);
    }
}