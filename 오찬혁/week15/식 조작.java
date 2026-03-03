package com.codingtest;

import java.util.ArrayList;
import java.util.List;

public class 식조작 {
	public static void main(String[] args) {
		System.out.println(new BracketExplorer("2-1x5-4x3+2").findMax()); // 11
		System.out.println(new BracketExplorer("2x3-1").findMax());        // 5
	}

	static class ExpressionParser{
		final List<Long> nums = new ArrayList<>();
		final List<Character> ops = new ArrayList<>();

		ExpressionParser(String expression) {
			StringBuilder sb = new StringBuilder();
			for (char c : expression.toCharArray()) {
				if (c == '+' || c == '-' || c == 'x') {
					nums.add(Long.parseLong(sb.toString()));
					ops.add(c);
					sb.setLength(0);
				} else {
					sb.append(c);
				}
			}

			nums.add(Long.parseLong(sb.toString()));
		}
	}

	static class ExpressionEvaluator{
		private final List<Long> nums;
		private final List<Character> ops;

		ExpressionEvaluator(List<Long> nums, List<Character> ops) {
			this.nums = new ArrayList<>(nums);
			this.ops = new ArrayList<>(ops);
		}

		long evaluate() {
			if (ops.isEmpty()) {
				return nums.get(0);
			}
			return calcWithPriority();
		}

		static long calcRange(List<Long> nums, List<Character> ops, int i, int j) {
			List<Long> subNums = new ArrayList<>(nums.subList(i, j + 2));
			List<Character> subOps = new ArrayList<>(ops.subList(i, j + 1));
			return new ExpressionEvaluator(subNums, subOps).evaluate();
		}

		private long calcWithPriority() {
			List<Long> n = new ArrayList<>(nums);
			List<Character> o = new ArrayList<>(ops);

			int idx = 0;
			while (idx < o.size()) {
				if (o.get(idx) == 'x') {
					n.set(idx, n.get(idx) * n.get(idx + 1));
					n.remove(idx + 1);
					o.remove(idx);
				} else {
					idx++;
				}
			}

			long result = n.get(0);
			for (int k = 0; k < o.size(); k++) {
				if (o.get(k) == '+') {
					result += n.get(k + 1);
				} else {
					result -= n.get(k + 1);
				}
			}
			return result;
		}
	}

	static class BracketExplorer{
		private final List<Long> nums;
		private final List<Character> ops;

		public BracketExplorer(String expression) {
			ExpressionParser parser = new ExpressionParser(expression);
			this.nums = parser.nums;
			this.ops = parser.ops;
		}

		long findMax() {
			if (ops.isEmpty()) {
				return nums.get(0);
			}

			long max = Long.MIN_VALUE;
			for (int i = 0; i < ops.size(); i++) {
				for (int j = i; j < ops.size(); j++) {
					max = Math.max(max, calcWithBracket(i, j));
				}
			}
			return max;
		}

		private long calcWithBracket(int i, int j) {
			long bracket = ExpressionEvaluator.calcRange(nums, ops, i, j);

			List<Long> newNums = new ArrayList<>();
			List<Character> newOps = new ArrayList<>();

			for (int k = 0; k < i; k++) {
				newNums.add(nums.get(k));
				newOps.add(ops.get(k));
			}
			newNums.add(bracket);
			for (int k = j + 1; k < ops.size(); k++) {
				newOps.add(ops.get(k));
				newNums.add(nums.get(k + 1));
			}

			return new ExpressionEvaluator(newNums, newOps).evaluate();
		}
	}
}
