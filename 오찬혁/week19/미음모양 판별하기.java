package com.shinhan;

import java.util.Arrays;

public class 미음모양판별하기 {
	public static void main(String[] args) {
		String[][] grids = {
			{".....", ".XXX.", ".X.X.", ".XXX.", "....."},
			{"XXXXX", "XXXXX", "XXX.X", "XXX.X", "XXXXX"},
			{"XXXXX", "X...X", "X.X.X", "X...X", "XXXXX"},
			{"....X", ".....", "XXX..", "X.X..", "XXX.."},
			{".......", "XXX.XXX", "X.X.X.X", "XXX.XXX", "......."},
			{"XXXXX", "XX.XX", "X...X", "XX.XX", "XXXXX"}
		};

		System.out.println(Arrays.toString(solution(grids)));
	}

	static boolean[] solution (String[][] grids){
		boolean[] result = new boolean[grids.length];
		for (int i = 0; i < grids.length; i++) {
			result[i] = check(grids[i]);
		}
		return result;
	}

	static boolean check(String[] grid) {
		int rows = grid.length;
		int cols = grid[0].length();

		int minR = rows, maxR = -1, minC = cols, maxC = -1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i].charAt(j) == 'X') {
					minR = Math.min(minR, i);
					maxR = Math.max(maxR, i);
					minC = Math.min(minC, j);
					maxC = Math.max(maxC, j);
				}
			}
		}

		if(maxR == -1) return false;
		if(maxR - minR < 2 || maxC - minC < 2)
			return false;

		for (int j = minC; j <= maxC; j++) {
			if(grid[minR].charAt(j) != 'X') return false;
			if(grid[maxR].charAt(j) != 'X') return false;
		}
		for (int i = minR; i <= maxR; i++) {
			if(grid[i].charAt(minC) != 'X') return false;
			if(grid[i].charAt(maxC) != 'X') return false;
		}

		int iMinR = rows, iMaxR = -1, iMinC = cols, iMaxC = -1;
		for (int i = minR + 1; i < maxR; i++) {
			for (int j = minC + 1; j < maxC; j++) {
				if (grid[i].charAt(j) == '.') {
					iMinR = Math.min(iMinR, i);
					iMaxR = Math.max(iMaxR, i);
					iMinC = Math.min(iMinC, j);
					iMaxC = Math.max(iMaxC, j);
				}
			}
		}

		if(iMaxR == -1) return false;

		for (int i = iMinR; i <= iMaxR; i++) {
			for (int j = iMinC; j <= iMaxC; j++) {
				if(grid[i].charAt(j) != '.') return false;
			}
		}

		for (int i = minR + 1; i < maxR; i++) {
			for (int j = minC + 1; j < maxC; j++) {
				if(i >= iMinR && i <= iMaxR && j >= iMinC && j <= iMaxC) continue;
				if(grid[i].charAt(j) != 'X') return false;
			}
		}

		return true;

	}

}
