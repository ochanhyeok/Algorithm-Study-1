import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int x1, y1, x2, y2, cnt;

        Node(int x1, int y1, int x2, int y2, int cnt) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        List<int[]> coins = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);

                if (board[i][j] == 'o') {
                    coins.add(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs(
                coins.get(0)[0], coins.get(0)[1],
                coins.get(1)[0], coins.get(1)[1]
        ));
    }

    static int bfs(int x1, int y1, int x2, int y2) {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x1, y1, x2, y2, 0));

        visited[x1][y1][x2][y2] = true;

        while (!q.isEmpty()) {

            Node cur = q.poll();

            if (cur.cnt >= 10) return -1;

            for (int d = 0; d < 4; d++) {

                int nx1 = cur.x1 + dx[d];
                int ny1 = cur.y1 + dy[d];

                int nx2 = cur.x2 + dx[d];
                int ny2 = cur.y2 + dy[d];

                boolean fall1 = out(nx1, ny1);
                boolean fall2 = out(nx2, ny2);

                if (fall1 && fall2) continue;

                if (fall1 || fall2) return cur.cnt + 1;

                if (board[nx1][ny1] == '#') {
                    nx1 = cur.x1;
                    ny1 = cur.y1;
                }

                if (board[nx2][ny2] == '#') {
                    nx2 = cur.x2;
                    ny2 = cur.y2;
                }

                if (!visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    q.add(new Node(nx1, ny1, nx2, ny2, cur.cnt + 1));
                }
            }
        }

        return -1;
    }

    static boolean out(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}