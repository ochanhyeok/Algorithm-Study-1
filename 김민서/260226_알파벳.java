import java.util.*;
import java.io.*;

class Main {
    static char[][] alph;
    static int[] alphabet = new int[26];
    static int prevCnt = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
                      
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        alph = new char[R][C];
        
        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            alph[i] = line.toCharArray();
        }
        
        alphabet[alph[0][0] - 'A'] = 1;
        dfs(0, 0, 1, R, C);
        
        System.out.println(prevCnt);
    }
    
    static void dfs(int y, int x, int cnt, int R, int C) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(ny < R && nx < C && ny >= 0 && nx >= 0 && alphabet[alph[ny][nx] - 'A'] == 0) {
                alphabet[alph[ny][nx] - 'A'] = 1;
            
                dfs(ny, nx, cnt + 1, R, C);
            
                alphabet[alph[ny][nx] - 'A'] = 0;
            }
        }
        
        if(prevCnt < cnt) {
            prevCnt = cnt;
        }
        return;
    }
}