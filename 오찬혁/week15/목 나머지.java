package com.codingtest;

public class 몫나머지 {

	public static void main(String[] args) {
		System.out.println(solution(2));
		System.out.println(solution(3));
	}

	static long solution(int n) {
		return (long)(n + 1) * (n - 1) * n / 2;
	}
}

