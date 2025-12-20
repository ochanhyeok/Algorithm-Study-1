package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시의 개수, 도로의 개수, 거리 정보, 출발 도시의 번호
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 연결
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        // 거리배열 초기화
        int[] dist = new int[N + 1];
        for(int i = 1; i <= N; i++){
            dist[i] = -1;
        }
        dist[X] = 0;

        // 시작점 0부터 시작
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(X);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph[now]) {
                // 아직 안 가본 도시면 거리 + 1하고 큐 맨 뒤에 넣음
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append("\n");
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }

    }
}
