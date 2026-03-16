import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        double[] p = new double[4];
        boolean[][] visited = new boolean[2 * n + 1][2 * n + 1];

        for (int i = 0; i < 4; i++) {
            p[i] = (double) Integer.parseInt(st.nextToken()) / 100;
        }

        visited[n][n] = true;
        
        double answer = backtrack(n, n, 1.0, 0, p, visited);


        System.out.println(answer);
    }

    static double backtrack(int y, int x, double current, int cnt, double[] p, boolean[][] visited) {
        double result = 0;

        if (cnt == n) {
            return current;
        }

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < 4; i++) {
            if (p[i] == 0) continue;

            int ny = y + dir[i][0];
            int nx = x + dir[i][1];

            if (ny < 0 || ny > 2 * n || nx < 0 || nx > 2 * n) continue;

            if (visited[ny][nx]) continue;
            visited[ny][nx] = true;
            result += backtrack(ny, nx, current * p[i], cnt + 1, p, visited);
            visited[ny][nx] = false;
        }

        return result;
    }
}