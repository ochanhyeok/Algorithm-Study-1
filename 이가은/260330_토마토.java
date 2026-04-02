import java.io.*;
import java.util.*;

public class Main {

    static int M, N, H;
    static int[][][] box;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        box = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    box[h][y][x] = Integer.parseInt(st.nextToken());

                    if (box[h][y][x] == 1) {
                        q.offer(new int[]{h, y, x});
                    }
                }
            }
        }

        bfs();

        int answer = 0;

        for (int h = 0; h < H; h++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (box[h][y][x] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, box[h][y][x]);
                }
            }
        }

        System.out.println(answer - 1);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0];
            int y = cur[1];
            int x = cur[2];

            for (int d = 0; d < 6; d++) {
                int nz = z + dz[d];
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                }

                if (box[nz][ny][nx] != 0) {
                    continue;
                }

                box[nz][ny][nx] = box[z][y][x] + 1;
                q.offer(new int[]{nz, ny, nx});
            }
        }
    }
}