package com.shinhan;

import java.util.Arrays;

public class 발전량 {
	public static void main(String[] args) {
		int[] predict1 = {1, 13, 15, 12, 3, 1, 10};
		int k1 = 4;

		int[] predict2 = {0, 10, 0, 8, 0, 12};
		int k2 = 1;

		int[] predict3 = {11, 3, 1, 6, 20, 7, 1, 0, 0};
		int k3 = 6;

		System.out.println(Arrays.toString(solution(predict1, k1)));
		System.out.println(Arrays.toString(solution(predict2, k2)));
		System.out.println(Arrays.toString(solution(predict3, k3)));
	}

	static int[] solution(int[] predict, int k) {
		int n = predict.length;
		int[] base = new int[n];

		for (int i = 0; i < n; i++) {
			base[i] = (predict[i] + k - 1) / k;
		}

		int[] left = new int[n];
		int[] right = new int[n];

		left[0] = base[0];
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(base[i], left[i - 1] - 1);
		}

		right[n - 1] = base[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(base[i], right[i + 1] - 1);
		}

		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			answer[i] = Math.max(left[i], right[i]) * k;
		}

		return answer;
	}
}
