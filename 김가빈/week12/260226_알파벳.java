import java.util.*;
import java.io.*;

class Main{
    static boolean[] visited; 
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int max = 0;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] board = new char[R][C];
        visited = new boolean[26];
        
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                board[i][j] = str.charAt(j);
            }
        }
        visited[board[0][0]-'A'] = true; 
        dfs(board, 0,0,1);
        System.out.println( max);
    }
    
    public static void dfs(char[][] board, int ci, int cj, int cnt){
        max = Math.max(max, cnt);
        
        for(int d=0; d<4; d++){
            int ni = ci + di[d];
            int nj = cj + dj[d];
            
            if( ni <0 || nj <0 || ni >=board.length || nj >= board[ni].length ) continue;
            if (visited[board[ni][nj]-'A'] == false) {
                visited[board[ni][nj]-'A'] = true;
                dfs(board, ni, nj, cnt+1);
                visited[board[ni][nj]-'A'] = false;
            }
        }
    }
}