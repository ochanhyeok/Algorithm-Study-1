import java.util.*;
import java.io.*;
 
public class Main {
    
    static int[][] board;
    static int[][] copy;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0;
    static int n = 0;
    static int m = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0);
        
        System.out.println(answer);
    }
    
    static void dfs(int dpt) {
        if(dpt == 3) {
            a();
            return;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 0) {
                    //visited[i][j] = true;
                    //wall[dpt][0] = i;
                    //wall[dpt][1] = j;
                    board[i][j] = 1;
                    dfs(dpt + 1);
                    board[i][j] = 0;
                }
            }
        }
    }
    
    static void a() {
        copy = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                copy[i][j] = board[i][j];
            }
        }
        
        bfs();
        
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copy[i][j] == 0) {
                    cnt++;
                }
            }
        }
        
        answer = Math.max(answer, cnt);
    }
    
    
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copy[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= n || ny >= m || nx < 0 || ny < 0) continue;
                
                if(copy[nx][ny] == 0) {
                    if(copy[nx][ny] == 0) copy[nx][ny] = 2;
                    q.add(new int[] {nx, ny});
                } else continue;
            }
        }
    }
}