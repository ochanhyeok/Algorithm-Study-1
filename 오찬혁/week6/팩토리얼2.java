package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long result = fac(N);
		System.out.println(result);
	}

	static long fac(int n) {
		if (n == 0) {
			return 1;
		}
		return n * fac(n - 1);
	}
}
