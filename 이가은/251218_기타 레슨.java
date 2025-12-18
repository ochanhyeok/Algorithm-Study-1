package algorithm.boj.ex2343d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int minSize = Arrays.stream(arr).max().getAsInt(); // 하한 용량
		int maxSize = Arrays.stream(arr).sum(); // 상한 용량

		int left = minSize;
		int right = maxSize;
		int answer = right;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (can(mid)) {
				answer = mid;
				right = mid - 1; // 더 작은 C 가능한지
			} else {
				left = mid + 1; // 더 큰 C 필요
			}
		}

		System.out.println(answer);

	}

	static boolean can(int C) {
		int count = 1; // 블루레이 1개부터 시작
		int sum = 0;

		for (int x : arr) {
			if (sum + x <= C) {
				sum += x;
			} else {
				count++;
				sum = x;
				if (count > M)
					return false; // 이미 초과면 바로 탈출
			}
		}
		return true; // M개 이하로 가능
	}

}
