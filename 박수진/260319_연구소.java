import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[][] map;
    static int maxSafe = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        n = Integer.parseInt(st.nextToken()); // 세로 크기
        m = Integer.parseInt(st.nextToken()); // 가로 크기
        
        map = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0); // 벽 3개 세우기 시작
        System.out.println(maxSafe);
    }
    
    // 벽 3개를 세우는 DFS
    static void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCount + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    static void bfs() {
        int[][] copyMap = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        // 바이러스 위치 모두 큐에 삽입
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        // BFS로 전염
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        // 안전 영역 계산
        int safeCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    safeCount++;
                }
            }
        }

        maxSafe = Math.max(maxSafe, safeCount);
    }
}