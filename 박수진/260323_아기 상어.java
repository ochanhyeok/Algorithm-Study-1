import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int sharkX, sharkY;
    static int sharkSize = 2;
    static int eatCount = 0;
    static int time = 0;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static class Fish implements Comparable<Fish> {
        int x, y, dist;

        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.dist != o.dist) return this.dist - o.dist;
            if (this.x != o.x) return this.x - o.x;
            return this.y - o.y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0; // 시작 위치는 빈칸처럼 처리
                }
            }
        }

        while (true) {
            Fish target = bfs();

            // 더 이상 먹을 물고기가 없으면 종료
            if (target == null) break;

            // 해당 물고기 먹으러 이동
            sharkX = target.x;
            sharkY = target.y;
            time += target.dist;

            // 물고기 먹기
            map[sharkX][sharkY] = 0;
            eatCount++;

            // 현재 크기만큼 먹으면 크기 증가
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);
    }

    static Fish bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        List<Fish> candidates = new ArrayList<>();

        q.offer(new int[]{sharkX, sharkY, 0});
        visited[sharkX][sharkY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                // 상어보다 큰 물고기 칸은 지나갈 수 없음
                if (map[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;

                // 먹을 수 있는 물고기면 후보 추가
                if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
                    candidates.add(new Fish(nx, ny, dist + 1));
                }

                // 지나갈 수 있는 칸이면 계속 탐색
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }

        if (candidates.isEmpty()) return null;

        Collections.sort(candidates);
        return candidates.get(0);
    }
}