package code;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 예시 입력
        String[][] grids = {
            {".....", "..XXX.", "..X.X.", "..XXX.", "....."},
            {"XXXXX", "XXXXX", "XXX.X", "XXX.X", "XXXXX"},
            {"XXXXX", "X...X", "X.X.X", "X...X", "XXXXX"},
            {".....", ".....", ".XXX..", ".X.X..", ".XXX.."},
            {".....", ".XXX.XX", ".X.X.X.X", ".XXX.XX", "......."},
            {"XXXXX", "XX.XX", "X...X", "XX.XX", "XXXXX"}
        };

        boolean[] result = sol.solution(grids);

        System.out.println(Arrays.toString(result));
    }
}

class Solution {

    public boolean[] solution(String[][] grids) {
        boolean[] answer = new boolean[grids.length];

        for (int i = 0; i < grids.length; i++) {
            answer[i] = isMieum(grids[i]);
        }

        return answer;
    }

    private boolean isMieum(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();

        int minR = n, maxR = -1, minC = m, maxC = -1;
        int blackCount = 0;

        // 1. 검은칸 위치 + bounding box
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == 'X') {
                    blackCount++;
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        if (blackCount == 0) return false;

        // 2. 외부는 직사각형 형태여야 함 (bounding box 안에 X 또는 내부구멍만 존재)
        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                if (grid[i].charAt(j) == '.') {
                    // 내부 구멍 후보
                    continue;
                }
            }
        }

        // 3. 내부 구멍 찾기 (BFS)
        boolean[][] visited = new boolean[n][m];
        int holeCount = 0;

        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                if (grid[i].charAt(j) == '.' && !visited[i][j]) {
                    holeCount++;

                    // 구멍은 1개만 있어야 함
                    if (holeCount > 1) return false;

                    // BFS로 구멍 영역 확인
                    int minHr = n, maxHr = -1, minHc = m, maxHc = -1;

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int r = cur[0], c = cur[1];

                        minHr = Math.min(minHr, r);
                        maxHr = Math.max(maxHr, r);
                        minHc = Math.min(minHc, c);
                        maxHc = Math.max(maxHc, c);

                        int[] dr = {1, -1, 0, 0};
                        int[] dc = {0, 0, 1, -1};

                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr < minR || nr > maxR || nc < minC || nc > maxC) continue;
                            if (visited[nr][nc]) continue;
                            if (grid[nr].charAt(nc) == '.') {
                                visited[nr][nc] = true;
                                q.offer(new int[]{nr, nc});
                            }
                        }
                    }

                    // 4. 구멍이 직사각형인지 확인
                    for (int r = minHr; r <= maxHr; r++) {
                        for (int c = minHc; c <= maxHc; c++) {
                            if (grid[r].charAt(c) != '.') return false;
                        }
                    }
                }
            }
        }

        // 구멍이 반드시 1개 있어야 함
        if (holeCount != 1) return false;

        // 5. 외부에 불필요한 X 있는지 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == 'X') {
                    if (i < minR || i > maxR || j < minC || j > maxC) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}