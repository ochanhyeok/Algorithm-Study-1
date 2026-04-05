import java.io.*;
import java.util.*;

public class Main {

    static int M, N, H;
    static int[][][] box;
    static Queue<Point> queue = new LinkedList<>();

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static class Point {
        int x, y, z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        box = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        queue.offer(new Point(m, n, h));
                    }
                }
            }
        }

        bfs();

        int answer = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, box[h][n][m]);
                }
            }
        }

        System.out.println(answer - 1);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int d = 0; d < 6; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nz = cur.z + dz[d];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H) {
                    continue;
                }

                if (box[nz][ny][nx] == 0) {
                    box[nz][ny][nx] = box[cur.z][cur.y][cur.x] + 1;
                    queue.offer(new Point(nx, ny, nz));
                }
            }
        }
    }
}