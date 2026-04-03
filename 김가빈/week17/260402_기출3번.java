import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public boolean[] solution(String[][] grids) {
        boolean[] answer = new boolean[grids.length];

        for (int i = 0; i < grids.length; i++) {
            char[][] board = toBoard(grids[i]);
            answer[i] = isConsonant(board);
        }

        return answer;
    }

    private char[][] toBoard(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = grid[i].toCharArray();
        }
        return board;
    }

    private boolean isConsonant(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // 1) 내부 흰 영역(구멍) 찾기
        boolean[][] visitedDot = new boolean[n][m];
        List<List<int[]>> innerHoles = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == '.' && !visitedDot[r][c]) {
                    List<int[]> comp = new ArrayList<>();
                    boolean touchesBorder = bfsDot(board, r, c, visitedDot, comp);

                    if (!touchesBorder) {
                        innerHoles.add(comp);
                    }
                }
            }
        }

        // 내부 구멍은 정확히 1개여야 함
        if (innerHoles.size() != 1) return false;

        // 2) 그 내부 구멍이 직사각형인지 검사
        if (!isRectangle(innerHoles.get(0), board)) return false;

        // 3) 검은색 X 영역이 하나로 연결되어 있는지 검사
        if (!isSingleBlackComponent(board)) return false;

        return true;
    }

    private boolean bfsDot(char[][] board, int sr, int sc, boolean[][] visited, List<int[]> comp) {
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        boolean touchesBorder = false;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            comp.add(cur);

            if (r == 0 || r == n - 1 || c == 0 || c == m - 1) {
                touchesBorder = true;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc] || board[nr][nc] != '.') continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }

        return touchesBorder;
    }

    private boolean isRectangle(List<int[]> hole, char[][] board) {
        int minR = Integer.MAX_VALUE, maxR = Integer.MIN_VALUE;
        int minC = Integer.MAX_VALUE, maxC = Integer.MIN_VALUE;

        for (int[] cell : hole) {
            minR = Math.min(minR, cell[0]);
            maxR = Math.max(maxR, cell[0]);
            minC = Math.min(minC, cell[1]);
            maxC = Math.max(maxC, cell[1]);
        }

        int expectedArea = (maxR - minR + 1) * (maxC - minC + 1);
        if (hole.size() != expectedArea) return false;

        for (int r = minR; r <= maxR; r++) {
            for (int c = minC; c <= maxC; c++) {
                if (board[r][c] != '.') return false;
            }
        }

        return true;
    }

    private boolean isSingleBlackComponent(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int totalX = 0;
        int sr = -1, sc = -1;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == 'X') {
                    totalX++;
                    if (sr == -1) {
                        sr = r;
                        sc = c;
                    }
                }
            }
        }

        if (totalX == 0) return false;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc] || board[nr][nc] != 'X') continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
                count++;
            }
        }

        return count == totalX;
    }
}