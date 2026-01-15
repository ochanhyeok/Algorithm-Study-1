import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static boolean[][] visited;
    static int answer, n, m;
    static boolean destination = false;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        if (maps[0][0] == 0 || maps[n-1][m-1] == 0)
            return -1;
        
        int[][] dist = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{0, 0});
        dist[0][0] = 1;
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                // 경계 체크
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 벽 체크
                if (maps[nx][ny] == 0) continue;

                // 방문 체크
                if (dist[nx][ny] != 0) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        
        }
        
        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }
}