package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = 0;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int left = 0;
		int right = n - 1;

		while (left < right) {
			int sum = arr[left] + arr[right];

			if (sum == x) {
				cnt++;
				left++;
				right--;
			} else if (sum > x) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(cnt);
	}
}
