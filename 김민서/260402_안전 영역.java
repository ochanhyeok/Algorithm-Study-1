import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
     
        int max = 0;
        
        for (int i = 0; i <= 100; i++) {
            
            int cnt = findGroup(i);
           
            if(cnt > max) {
                max = cnt;
            }
        }
        
        System.out.println(max);        
       
    }
    
    static int findGroup(int h) {
        boolean[][] isDown = new boolean[N][N];
        int cnt = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] <= h) {
                    isDown[i][j] = true;
                } else {
                    isDown[i][j] = false;
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!isDown[i][j]) {
                    cnt++;
                    
                    isDown[i][j] = true;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] {i, j});
                    
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        int cx = cur[0];
                        int cy = cur[1];
                        
                        for(int a = 0; a < 4; a++) {
                            int nx = cx + dx[a];
                            int ny = cy + dy[a];
                            
                            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                            
                            if(!isDown[nx][ny]) {
                                q.offer(new int[] {nx, ny});
                                isDown[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        
        return cnt;
    }
}