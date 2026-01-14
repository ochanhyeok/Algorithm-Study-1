package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호제작 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String P = st.nextToken();
		int K = Integer.parseInt(st.nextToken());

		boolean[] isPrime = new boolean[K + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		if (K > 1) {
			isPrime[1] = false;
		}

		for (int i = 2; i * i <= K; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= K; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int p = 2; p < K; p++) {
			if (!isPrime[p]) {
				continue;
			}

			if (modString(P, p) == 0) {
				System.out.println("BAD " + p);
				return;
			}
		}

		System.out.println("GOOD");
	}

	static int modString(String s, int m) {
		int rem = 0;
		for (int i = 0; i < s.length(); i++) {
			rem = (rem * 10 + (s.charAt(i) - '0')) % m;
		}
		return rem;
	}
}
