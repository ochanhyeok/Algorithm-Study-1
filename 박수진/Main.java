import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long count = 0;

    static boolean[] colUsed;   // 열 사용 여부
    static boolean[] diag1Used; // (row - col + N - 1)  '\' 대각선
    static boolean[] diag2Used; // (row + col)          '/' 대각선

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        colUsed = new boolean[N];
        diag1Used = new boolean[2 * N - 1];
        diag2Used = new boolean[2 * N - 1];

        dfs(0);
        System.out.println(count);
    }

    static void dfs(int row) {
        // row행까지 모두 놓았으면 N개 배치 성공
        if (row == N) {
            count++;
            return;
        }

        // row행에 둘 열(col) 선택
        for (int col = 0; col < N; col++) {
            int d1 = row - col + (N - 1);
            int d2 = row + col;

            if (colUsed[col] || diag1Used[d1] || diag2Used[d2]) continue;

            // 놓기
            colUsed[col] = true;
            diag1Used[d1] = true;
            diag2Used[d2] = true;

            dfs(row + 1);

            // 되돌리기(백트래킹)
            colUsed[col] = false;
            diag1Used[d1] = false;
            diag2Used[d2] = false;
        }
    }
}
