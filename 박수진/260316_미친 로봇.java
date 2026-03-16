import java.io.*;
import java.util.*;

class Main {
    static int moves;
    static double[] p = new double[4]; // 동서남북 확률
    static boolean[][] visited;
    static double answer = 0.0;
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        moves = Integer.parseInt(st.nextToken());
        double e = Integer.parseInt(st.nextToken()) / 100.0;
        double w = Integer.parseInt(st.nextToken()) / 100.0;
        double s = Integer.parseInt(st.nextToken()) / 100.0;
        double n = Integer.parseInt(st.nextToken()) / 100.0;
        
        p[0] = e;
        p[1] = w;
        p[2] = s;
        p[3] = n;
        
        visited = new boolean[30][30];
        
        visited[15][15] = true;
        
        dfs(15, 15, 0, 1.0);
        
        System.out.println(answer);
    }
    
    static void dfs(int x, int y, int depth, double prob) {
        // moves만큼 이동 완료
        if (depth == moves) {
            answer += prob;
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (p[i] == 0.0) continue;
            
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (visited[nx][ny]) continue;
            
            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, prob * p[i]);
            visited[nx][ny] = false; // 백트래킹
        }
    } 
}