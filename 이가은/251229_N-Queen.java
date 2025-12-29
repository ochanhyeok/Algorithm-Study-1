import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int answer = 0;
	static int[] queenCol;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		queenCol = new int[n]; // row index에 해당하는 col 값 저장
		Arrays.fill(queenCol, -1);

		placeQueen(0);
		System.out.println(answer);
	}

	static void placeQueen(int row) {
		// 현재 row에서 놓을 수 있는 col 탐색
		for (int col = 0; col < n; col++) {
			queenCol[row] = col; // 해당 row에 col 값 업데이트

			// 해당 col에 놓으면 안 되는 경우
			if (!isValidCol(row) || !isValidCross(row)) {
				// 백트래킹
				queenCol[row] = -1;
				continue;
			}

			// 다음 행에 퀸 배치
			if (row < n - 1)
				placeQueen(row + 1);

			// 모든 행 배치한 경우
			if (row == n - 1)
				answer++;

			// 백트래킹
			queenCol[row] = -1;
		}

	}

	// 올바른 열에 배치했는지
	static boolean isValidCol(int row) {
		int col = queenCol[row]; // 방금 놓은 열
		for (int r = 0; r < row; r++) {
			if (queenCol[r] == col)
				return false;
		}
		return true;
	}

	// 기준 행에 있는 퀸의 위치와 대각선인지
	static boolean isValidCross(int row) {
		int col = queenCol[row]; // 방금 놓은 퀸의 열
		for (int r = 0; r < row; r++) {
			int c = queenCol[r];
			if (Math.abs(row - r) == Math.abs(col - c))
				return false;
		}
		return true;
	}

}