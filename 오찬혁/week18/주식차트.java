package com.shinhan;

import java.util.ArrayList;
import java.util.List;

public class 주식차트 {
	public int[] solution(int[] prices){
		int n = prices.length;

		int[] leftUp = new int[n];
		int[] leftDown = new int[n];

		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i - 1]) {
				leftUp[i] = leftUp[i - 1] + 1;
			}
			if (prices[i] < prices[i - 1]) {
				leftDown[i] = leftDown[i - 1] + 1;
			}
		}

		int[] rightUp = new int[n];
		int[] rightDown = new int[n];
		for (int i = n - 2; i >= 0; i--) {
			if (prices[i] > prices[i - 1]) {
				rightDown[i] = rightDown[i + 1] + 1;
			}
			if (prices[i] < prices[i - 1]) {
				rightUp[i] = rightUp[i + 1] + 1;
			}
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (leftUp[i] > 0 && rightDown[i] > 0) {
				result.add(Math.max(leftUp[i], rightDown[i]));
			} else if (leftDown[i] > 0 && rightUp[i] > 0) {
				result.add(Math.max(rightUp[i], leftDown[i]));
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}
}
