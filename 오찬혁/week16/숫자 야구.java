package com.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자야구 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] nums = new int[N];
		int[] strikes = new int[N];
		int[] balls = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			nums[i] = Integer.parseInt(st.nextToken());
			strikes[i] = Integer.parseInt(st.nextToken());
			balls[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;

		for (int p = 123; p <= 987; p++) {
			int a = p / 100;
			int b = p / 10 % 10;
			int c = p % 10;

			if (a == 0 || b == 0 || c == 0) {
				continue;
			}
			if (a == b || b == c || c == a) {
				continue;
			}

			boolean valid = true;
			for (int i = 0; i < N; i++) {
				int qa = nums[i] / 100;
				int qb = nums[i] / 10 % 10;
				int qc = nums[i] % 10;

				int strike = 0, ball = 0;
				if (a == qa) {
					strike++;
				}
				if (b == qb) {
					strike++;
				}
				if (c == qc) {
					strike++;
				}

				if (a == qb || a == qc) {
					ball++;
				}
				if (b == qa || b == qc) {
					ball++;
				}
				if (c == qa || c == qb) {
					ball++;
				}

				if (strike != strikes[i] || ball != balls[i]) {
					valid = false;
					break;
				}

			}

			if (valid) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
