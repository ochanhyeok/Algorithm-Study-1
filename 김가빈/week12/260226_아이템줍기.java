import java.util.*;

class Solution {
    static int SIZE = 110;                 // 2배 확장 고려해서 넉넉히
    static int[][] rect = new int[SIZE][SIZE];
    static int[][] visited = new int[SIZE][SIZE];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 초기화(여러 테스트 케이스 대비)
        for (int i=0;i<SIZE;i++){
            Arrays.fill(rect[i], 0);
            Arrays.fill(visited[i], 0);
        }

        // 1) 사각형 채우기 (2배 스케일)
        for (int[] r : rectangle) {
            int lx = r[0]*2, ly = r[1]*2, rx = r[2]*2, ry = r[3]*2;
            for (int x = lx; x <= rx; x++) {
                for (int y = ly; y <= ry; y++) {
                    rect[x][y] = 1;
                }
            }
        }

        // 2) 내부 지우기
        for (int[] r : rectangle) {
            int lx = r[0]*2, ly = r[1]*2, rx = r[2]*2, ry = r[3]*2;
            for (int x = lx + 1; x <= rx - 1; x++) {
                for (int y = ly + 1; y <= ry - 1; y++) {
                    rect[x][y] = 0;
                }
            }
        }

        int sx = characterX*2, sy = characterY*2;
        int tx = itemX*2, ty = itemY*2;

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == tx && y == ty) {
                // 2배로 움직였으니 거리도 2배 -> /2
                return (visited[x][y] - 1) / 2;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) continue;
                if (rect[nx][ny] != 1) continue;      // 테두리만
                if (visited[nx][ny] != 0) continue;

                visited[nx][ny] = visited[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        return 0;
    }
}