import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 도로 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
        
        // 인접 리스트 구성
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
        }
        
        // BFS로 최단거리(dist) 계산
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        dist[X] = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(X);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph[cur]) {
                if (dist[next] != -1) {
                    continue;
                }
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }
        
        // 최단거리가 K인 도시 출력
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                answer.append(i).append('\n');
            }
        }
        
        if (answer.length() == 0) {
            System.out.println("-1");
        } else {
            System.out.print(answer);
        }
    }
}