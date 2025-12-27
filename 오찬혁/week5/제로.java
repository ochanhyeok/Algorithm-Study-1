package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stk = new Stack<>();
		int sum = 0;

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());

			if (n != 0) {
				stk.push(n);
				sum += n;
			} else {
				sum -= stk.pop();
			}
		}

		System.out.println(sum);
	}
}
