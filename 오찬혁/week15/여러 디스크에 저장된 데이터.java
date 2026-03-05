package com.codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 여러디스크에저장된데이터 {
	public static void main(String[] args) {
		int n1 = 3, m1 = 5;
		int[][] records1 = {{1, 1, 5}, {2, 4, 7}, {1, 5, 10}, {3, 1, 10}, {2, 1, 5}, {1, 3, 3}, {3, 2, 8}, {2, 2, 8}, {3, 4, 7}};
		int n2 = 2, m2 = 3;
		int[][] records2 = {{1, 2, 7}, {1, 1, 7}, {1, 3, 9}, {2, 1, 3}, {2, 2, 9}, {2, 3, 1}};
		System.out.println(Arrays.deepToString(solution(n1, m1, records1)));
		System.out.println(Arrays.deepToString(solution(n2, m2, records2)));
	}

	static int[][] solution(int n, int m, int[][] records) {
		List<int[]> result = new ArrayList<>();

		Map<Integer, List<Integer>> dataMap = new HashMap<>();
		Map<Integer, Integer> diskCount = new HashMap<>();

		for (int i = 0; i < records.length; i++) {
			int dataId = records[i][1];
			int diskNo = records[i][0];
			dataMap.computeIfAbsent(dataId, k -> new ArrayList<>()).add(i);
			diskCount.merge(diskNo, 1, Integer::sum);
		}

		while (true) {
			List<Integer> candidates = new ArrayList<>();
			for (List<Integer> idxList : dataMap.values()) {
				if (idxList.size() > 1) {
					candidates.addAll(idxList);
				}
			}

			if (candidates.isEmpty()) {
				break;
			}

			candidates.sort((i, j) -> {
				int[] a = records[i], b = records[j];
				if(a[2] != b[2]){
					return b[2] - a[2];
				}
				int cntA = diskCount.get(a[0]);
				int cntB = diskCount.get(b[0]);
				if (cntA != cntB) {
					return cntB - cntA;
				}
				return i - j;
			});

			int delIdx = candidates.get(0);
			int[] del = records[delIdx];
			result.add(new int[] {del[0], del[1]});

			dataMap.get(del[1]).remove(Integer.valueOf(delIdx));
			diskCount.merge(del[0], -1, Integer::sum);
		}

		return result.toArray(new int[0][]);
	}
}
