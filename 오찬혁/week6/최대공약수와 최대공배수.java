package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수와최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int result1 = gcd(a, b);
		int result2 = (a * b) / result1;

		sb.append(result1 + "\n").append(result2);

		System.out.println(sb);
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}
}
