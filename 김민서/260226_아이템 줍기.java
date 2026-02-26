import java.util.*;

class Solution {
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> road = new LinkedList<int[]>();

        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < 4; j++) {
                rectangle[i][j] *= 2;
            }
        }
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        int fill[][] = new int[101][101];
        for(int i = 0; i < 101; i++) {
            Arrays.fill(fill[i], -1);
        }
        
        for(int i = 0; i < rectangle.length; i++) {
            for(int x = rectangle[i][0]; x <= rectangle[i][2]; x++) {
                for(int y = rectangle[i][1]; y <= rectangle[i][3]; y++) {
                    fill[y][x] = 0;
                }
            }
        }
        
        for(int i = 0; i < rectangle.length; i++) {
            for(int x = rectangle[i][0] + 1; x < rectangle[i][2]; x++) {
                for(int y = rectangle[i][1] + 1; y < rectangle[i][3]; y++) {
                    fill[y][x] = -1;
                }
            }
        }
        
        road.offer(new int[]{characterY, characterX});
        
        while(!road.isEmpty()) {
            int[] now = road.poll();
            int cy = now[0];
            int cx = now[1];
            
            for(int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];    
                
                if(ny < 0 || nx < 0 || ny > 100 || nx > 100) continue;
                if(fill[ny][nx] != 0) continue;
                
                fill[ny][nx] = fill[cy][cx] + 1;
                
                if(ny == itemY && nx == itemX) {
                    return fill[ny][nx] / 2;
                }
                
                road.offer(new int[]{ny, nx});
            }
        }
        
        return -1;
    }
}