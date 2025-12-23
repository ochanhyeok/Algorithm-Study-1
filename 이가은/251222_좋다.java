import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Long.parseLong(st.nextToken());

		Arrays.sort(arr);

		int good = 0;

		for (int i = 0; i < n; i++) {
			long target = arr[i];
			int l = 0, r = n - 1;

			while (l < r) {
				if (l == i) {
					l++;
					continue;
				}
				if (r == i) {
					r--;
					continue;
				}

				long sum = arr[l] + arr[r];
				if (sum == target) {
					good++;
					break;
				} else if (sum < target) {
					l++;
				} else {
					r--;
				}
			}
		}

		System.out.println(good);
	}
}