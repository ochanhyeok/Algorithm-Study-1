import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int h = land.length;
        int w = land[0].length;
        
        boolean[][] visited = new boolean[h][w];
        int[] colSum = new int[w];
        
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
         
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (land[y][x] == 1 && !visited[y][x]) {
                    visited[y][x] = true;
                    q.add(new int[]{y, x});
                    
                    int size = 0;
                    boolean[] touched = new boolean[w];
                    
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int cy = cur[0], cx = cur[1];
                        
                        size++;
                        touched[cx] = true;
                        
                        for (int dir = 0; dir < 4; dir++) {
                            int ny = cy + dy[dir];
                            int nx = cx + dx[dir];
                            if ( ny >= 0 && ny < h && nx >= 0 && nx < w 
                                && !visited[ny][nx] && land[ny][nx] == 1
                               )  {
                                visited[ny][nx] = true;
                                q.add(new int[]{ny, nx});
                            }
                        }
                    }
                    
                    for (int col = 0; col < w; col++) {
                        if (touched[col]) colSum[col] += size;
                    }
                } 
            }
        }
        
        for (int v: colSum) answer = Math.max(answer, v);
        return answer;
        
    }
        
}