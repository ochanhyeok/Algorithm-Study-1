import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[] output;

	public static void main(String args[]) throws Exception {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		output = new int[r];
		c(0, 0, n, r);
		System.out.println(sb.toString());
	}

	public static void c(int dept, int start, int n, int r) {
		if (dept == r) {
			for (int i = 0; i < r; i++) {
				sb.append(output[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int j = start; j < n; j++) {
			output[dept] = j + 1;
			c(dept + 1, j + 1, n, r);
		}
	}
}
