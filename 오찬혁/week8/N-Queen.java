import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class practice {

	static int N;
	static int[] col;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		col = new int[N];

		dfs(0);
		System.out.println(cnt);
	}

	static void dfs(int row) {
		if (row == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			col[row] = i;
			if (isPossible(row)) {
				dfs(row + 1);
			}
		}
	}

	static boolean isPossible(int row) {
		for (int i = 0; i < row; i++) {
			if (col[row] == col[i]) {
				return false;
			}

			if (Math.abs(col[row] - col[i]) == Math.abs(row - i)) {
				return false;
			}
		}

		return true;
	}

}
