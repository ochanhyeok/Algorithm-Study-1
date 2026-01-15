import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean found = false;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N];
        
        // 배열은 생겼지만, ArrayList 객체는 하나도 만들어지지 않은 상태 (graph[0] -> null)
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>(); // 초기화
        }
        
        // 친구관계 저장
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        visited = new boolean[N];
        
        // i번 사람부터 친구 관계 탐색 시작
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;
            
            if (found) break;
        }
        
        System.out.println(found ? 1 : 0);      
    }
    
    static void dfs(int v, int depth) {
        if (found) return;
        if (depth == 4) {
            found = true;
            return;
        }
        
        for (int u : graph[v]) {
            if (!visited[u]) {
                visited[u] = true;
                dfs(u, depth+1);
                visited[u] = false; // 백트래킹
            }
        }
    }
}