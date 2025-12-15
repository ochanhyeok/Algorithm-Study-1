import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken()); // 1 ~ N까지의 수
		int M = Integer.parseInt(st.nextToken()); // 뽑는 숫자 개수

		for (int i = 1; i <= N; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(i);
			recur(M, sb);
		}

		System.out.println(answer.toString());
	}

	static void recur(int m, StringBuilder sb) {
		if (m - 1 == 0) {
			answer.append(sb + "\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			StringBuilder nextSb = new StringBuilder(sb);
			nextSb.append(" " + i);
			recur(m - 1, nextSb);
		}
	}

}