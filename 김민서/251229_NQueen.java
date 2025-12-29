package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NQueen {
	static int cnt = 0;
	static int n;
	static boolean[] col, diag1, diag2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        col = new boolean[n];
        diag1 = new boolean[2*n];
        diag2 = new boolean[2*n];

        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int row) {
        if (row == n) {
            cnt++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (!col[c] && !diag1[row + c] && !diag2[row - c + n]) {
                col[c] = diag1[row + c] = diag2[row - c + n] = true;
                dfs(row + 1);
                col[c] = diag1[row + c] = diag2[row - c + n] = false; // 복구
            }
        }
    }

}
