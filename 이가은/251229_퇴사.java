import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());

		int[] t = new int[n];
		int[] p = new int[n];
		int[] dp = new int[n + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		for (int current = 0; current < n; current++) {
			// dp[i] = i일이 시작될 때까지 얻을 수 있는 최대 수익
			// 0일: 상담 X → dp[0] = 0 , i일: 0 ~ i-1일까지의 선택이 끝난 상태
			// 먼저 상담 안 했을 경우 고려
			dp[current + 1] = Math.max(dp[current + 1], dp[current]);

			int end = current + t[current];

			// 상담한 경우 고려
			if (end <= n) {
				dp[end] = Math.max(dp[end], dp[current] + p[current]);
			}

		}

		System.out.println(dp[n]);

	}
}