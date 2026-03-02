package com.codingtest;

public class 주식구매 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 4}));
		System.out.println(solution(new int[] {1, 2, 4, 1, 2, 3}));
		System.out.println(solution(new int[] {4, 3, 2, 1, 4}));
		System.out.println(solution(new int[] {4, 3, 2, 1}));
		System.out.println(solution(new int[] {1, 10, 5, 11, 7}));
	}

	static int solution(int[] prices){
		final int NEG = Integer.MIN_VALUE / 2;
		int[] dp = {0, NEG, NEG, NEG, NEG, NEG};

		for (int p : prices) {
			int[] next = dp.clone();
			next[1] = Math.max(next[1], dp[0] - p);
			next[2] = Math.max(next[2], dp[1] - p);
			next[3] = Math.max(next[3], dp[1] + p);
			next[4] = Math.max(next[4], dp[2] + p);
			next[4] = Math.max(next[4], dp[3] - p);
			next[5] = Math.max(next[5], dp[4] + p);
			dp = next;
		}

		return Math.max(0, Math.max(dp[3], dp[5]));
	}
}
