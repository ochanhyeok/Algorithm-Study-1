package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 동전0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Integer[] coins = new Integer[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(coins, Collections.reverseOrder());

		int cnt = 0;
		int coin = K;

		for (int i = 0; i < N; i++) {
			if (coins[i] <= coin) {
				cnt += coin / coins[i];
				coin = coin % coins[i];
			}
		}

		System.out.println(cnt);
	}
}
