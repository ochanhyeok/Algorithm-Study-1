import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		long[] answer = new long[t];

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			long a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());

			answer[i] = (a * b) / mx(a, b);
		}

		for (int i = 0; i < t; i++) {
			System.out.println(answer[i]);
		}
	}

	public static long mx(long a, long b) {
		long temp = 0;
		while (b != 0) {
			temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

}