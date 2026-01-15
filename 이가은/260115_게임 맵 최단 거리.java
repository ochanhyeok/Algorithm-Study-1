import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int solution(int[][] maps) {
        int MAX_Y = maps.length;
        int MAX_X = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[MAX_Y][MAX_X];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};        
        
        queue.add(new int[] {0,0,1});
        
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            int y = position[0]; int x = position[1]; int currentDistance = position[2];
            
             if (y == MAX_Y - 1 && x == MAX_X -1) return currentDistance;
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i]; int nx = x + dx[i];
                if (ny < 0 || ny >= MAX_Y || nx < 0 || nx >= MAX_X || 
                    distance[ny][nx] > 0 || maps[ny][nx] == 0) 
                    continue;
                distance[ny][nx] = currentDistance + 1;
                queue.add(new int[]{ny, nx, currentDistance + 1});
            }
            
        }
        
                
        return -1;
    }
}