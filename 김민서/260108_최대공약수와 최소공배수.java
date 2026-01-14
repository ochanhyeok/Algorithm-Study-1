import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());

		long min = mx(a, b);
		System.out.println(min);
		System.out.println((a * b) / min);

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
