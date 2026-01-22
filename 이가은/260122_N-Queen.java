import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] placedByRow;
    static int answer;
    static boolean[][] board;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new boolean[N][N];

        placedByRow = new int[N]; // 각 행마다 어느 열에 놓았는지


        for (int c = 0; c < N; c++) {
            place(0, c);
        }

        System.out.println(answer);
    }

    static void place(int row, int col) {
        placedByRow[row] = col;
        board[row][col] = true;

        if (row == N - 1) {
            answer++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (validCol(row + 1, c) && validCross(row + 1, c)) {
                place(row + 1, c);
            }
        }

        placedByRow[row] = 0;
        board[row][col] = false;
    }

    static boolean validCol(int row, int col) {
        for (int r = 0; r < row; r++) {
            if (placedByRow[r] == col) return false;
        }
        return true;
    }

    static boolean validCross(int row, int col) {
        int k = 1;
        for (int r = row - 1; r >= 0; r--) {
            if (col - k >= 0 && board[r][col-k]) return false;
            if (col + k < N && board[r][col+k]) return false;
            k++;
        }

        return true;
    }
}