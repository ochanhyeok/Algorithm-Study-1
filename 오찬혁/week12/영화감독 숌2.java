package baekjoon;

import java.io.*;
import java.util.Arrays;

public class 영화감독숌2{

	static long[][][][] dp;
	static int[] digits;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());

		long lo = 666;
		long hi = 1_000_000_000_0000L;

		while (lo < hi) {
			long mid = (lo + hi) / 2;

			long c = count(mid);
			if (c >= N) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		System.out.println(lo);
	}

	static long count(long x) {
		if (x < 666) {
			return 0;
		}

		char[] ch = String.valueOf(x).toCharArray();
		int len = ch.length;
		digits = new int[len];
		for (int i = 0; i < len; i++) {
			digits[i] = ch[i] - '0';
		}

		dp = new long[len + 1][4][2][2];
		for (int i = 0; i <= len; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 2; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}

		return dfs(0, 0, 0, 1, len);
	}

	static long dfs(int pos, int cnt6, int has, int tight, int len) {
		if (pos == len) {
			return has == 1 ? 1 : 0;
		}
		if (dp[pos][cnt6][has][tight] != -1) {
			return dp[pos][cnt6][has][tight];
		}

		long res = 0;
		int limit = tight == 1 ? digits[pos] : 9;

		for (int d = 0; d <= limit; d++) {
			int nTight = (tight == 1 && d == limit) ? 1 : 0;
			int nCnt6 = cnt6;
			int nHas = has;

			if (d == 6) {
				nCnt6 = Math.min(3, cnt6 + 1);
			} else {
				nCnt6 = 0;
			}

			if (nCnt6 >= 3) {
				nHas = 1;
			}

			res += dfs(pos + 1, nCnt6, nHas, nTight, len);
		}

		dp[pos][cnt6][has][tight] = res;
		return res;
	}
}
