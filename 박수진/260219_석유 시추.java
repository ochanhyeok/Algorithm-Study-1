import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        int[][] group = new int[n][m];         // 해당 칸이 몇 번 덩어리인지 기록 (0 = 미방문)
        int[] size = new int[n * m + 1];       // 덩어리 크기
        Set<Integer>[] column = new HashSet[m]; // 열별 덩어리 id 집합
        for (int c = 0; c < m; c++) column[c] = new HashSet<>();

        int oilId = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && group[i][j] == 0) {
                    oilId++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    group[i][j] = oilId;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0], y = cur[1];
                        size[oilId]++;
                        column[y].add(oilId);

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d], ny = y + dy[d];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m
                                    && land[nx][ny] == 1 && group[nx][ny] == 0) {
                                group[nx][ny] = oilId;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        // 열마다 합산하여 최댓값 반환
        int answer = 0;
        for (int c = 0; c < m; c++) {
            int total = 0;
            for (int id : column[c]) total += size[id];
            answer = Math.max(answer, total);
        }

        return answer;
    }
}
