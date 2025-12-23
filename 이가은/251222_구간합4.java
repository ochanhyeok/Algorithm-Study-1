import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken()); // 개수 N
		int m = Integer.parseInt(st.nextToken()); // 횟수 M
		int[] arr = new int[n];
		int[] sumArr = new int[n];

		StringBuilder answer = new StringBuilder();

		int sum = 0;

		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			sumArr[i] = sum + num;
			sum += num;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;

			int sumStart = start != 0 ? sumArr[start - 1] : 0;
			int sumEnd = sumArr[end];
			answer.append(sumEnd - sumStart + "\n");
		}

		System.out.println(answer.toString());

	}

}
