import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n == 0) {
			System.out.println(n);
			return;
		}

		int[] fib = new int[n + 1];

		fib[1] = 1;

		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 2] + fib[i - 1];
		}

		System.out.println(fib[n]);
	}
}