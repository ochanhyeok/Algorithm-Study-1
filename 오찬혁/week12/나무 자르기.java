package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] woods = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			woods[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(woods);

		int left = 0;
		int right = woods[N - 1];

		int result = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (canCut(woods, mid, M)) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(result);
	}

	static boolean canCut(int[] woods, int mid, int M) {
		long totalCut = 0;

		for (int wood : woods) {
			int cutLength = wood - mid;
			if (cutLength > 0) {
				totalCut += cutLength;
			}
		}

		return totalCut >= M;
	}
}
