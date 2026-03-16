import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static double[] percent = new double[4]; // 동, 서, 남, 북
    static boolean[][] visited = new boolean[30][30];
    static double answer = 0.0;

    // 동, 서, 남, 북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4; i++) {
            percent[i] = Integer.parseInt(st.nextToken()) / 100.0;
        }

        int startX = 15;
        int startY = 15;
        visited[startX][startY] = true;

        dfs(startX, startY, 0, 1.0);

        System.out.println(answer);
    }

    static void dfs(int x, int y, int depth, double prob) {
        if (depth == N) {
            answer += prob;
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            if (percent[dir] == 0) continue;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, prob * percent[dir]);
            visited[nx][ny] = false;
        }
    }
}