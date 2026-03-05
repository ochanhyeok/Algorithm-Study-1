package com.codingtest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 스팸경고출력 {
	public static void main(String[] args) {
		/**
		 * 스팸체크 -> 스펨 맞으면 바로 경고
		 * 		-> 아니면 cnt + 1 하면서 저장하고 k번째까지 경고
		 */
		String[] approved1 = {"123-4567", "451-2314", "015-1643"};
		String[] spams1 = {"111-1111"};
		String[] calls1 = {"123-4567", "000-0022", "015-1643", "000-0022", "111-1111", "000-0022", "111-1111", "111-1111"};
		int k1 = 2;
		String[] approved2 = {"123-1000"};
		String[] spams2 = {"456-2000"};
		String[] calls2 = {"456-2000", "456-2000", "123-1000", "123-1000", "789-3000", "789-3000", "789-3000", "789-3000", "789-3000"};
		int k2 = 3;
		System.out.println(Arrays.toString(solution(approved1, spams1, calls1, k1)));
		System.out.println(Arrays.toString(solution(approved2, spams2, calls2, k2)));
	}

	static int[] solution(String[] approved, String[] spams, String[] calls, int k){
		Set<String> phoneMap = new HashSet<>(Arrays.asList(approved));
		Set<String> spamNum = new HashSet<>(Arrays.asList(spams));
		Map<String, Integer> nonNum = new HashMap<>();
		int[] result = new int[calls.length];

		for (int i = 0; i < calls.length; i++) {
			if (spamNum.contains(calls[i])) { // 스팸일 경우
				result[i] = 1;
			} else if (phoneMap.contains(calls[i])) { // 연락처에 있을 경우
				result[i] = 0;
			} else { // 연락처에 없는 경우
				nonNum.put(calls[i], nonNum.getOrDefault(calls[i], 0) + 1);
				if (nonNum.get(calls[i]) > k) {
					result[i] = 0;
				} else {
					result[i] = 1;
				}
			}
		}

		return result;
	}
}
