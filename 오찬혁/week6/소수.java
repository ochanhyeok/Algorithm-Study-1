import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = a; i <= b; i++) {
			if (isPrime(i)) {
				sum += i;

				if (i < min) {
					min = i;
				}
			}
		}

		if (sum > 0) {
			sb.append(sum + "\n").append(min);
		} else {
			sb.append(-1);
		}

		System.out.println(sb);
	}

	static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}
