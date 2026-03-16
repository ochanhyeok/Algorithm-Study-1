import java.util.*;
import java.io.*;

class Main {
    static char[][] board;
    static int answer;
    static int n, m;
    
    static int[] x = {0, 0, 1, -1};
    static int[] y = {1, -1, 0, 0};
    
    static class State {
        int x1, y1, x2, y2, cnt;
        
        State(int x1, int y1, int x2, int y2, int cnt) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.cnt = cnt;
        }
    }
    
    static boolean isOut(int a, int b) {
        return a <0 || a >= n || b < 0 || b >= m;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        
        List<int[]> coins = new ArrayList<>();
        
        for (int x = 0; x < n; x++) {
            String line = bf.readLine();
            for (int y = 0; y < m; y++) {
                board[x][y] = line.charAt(y);
                if (board[x][y] == 'o') {
                    coins.add(new int[]{x, y});
                    board[x][y] = '.';
                }
            }
        }
        
        int x1 = coins.get(0)[0];
        int y1 = coins.get(0)[1];
        int x2 = coins.get(1)[0];
        int y2 = coins.get(1)[1];
        
        boolean[][][][] visited = new boolean[n][m][n][m];
        Queue<State> q = new LinkedList<>();
        
        q.offer(new State(x1, y1, x2, y2, 0));
        visited[x1][y1][x2][y2] = true;
        
        while(!q.isEmpty()) {
            State cur = q.poll();
            
            if (cur.cnt >= 10) continue;
            
            for (int d = 0; d < 4; d++) {
                int nx1 = cur.x1 + x[d];
                int ny1 = cur.y1 + y[d];
                int nx2 = cur.x2 + x[d];
                int ny2 = cur.y2 + y[d];
                
                boolean out1 = isOut(nx1, ny1);
                boolean out2 = isOut(nx2, ny2);
                
                if (out1 && out2) continue;
                if (out1 || out2) {
                    System.out.println(cur.cnt + 1);
                    return;
                }
                
                if (board[nx1][ny1] == '#') {
                    nx1 = cur.x1;
                    ny1 = cur.y1;
                }
                if (board[nx2][ny2] == '#') {
                    nx2 = cur.x2;
                    ny2 = cur.y2;
                }
                
                if (!visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    q.offer(new State(nx1, ny1, nx2, ny2, cur.cnt+1));
                }
            }
        }
        
        System.out.println(-1);
        
    }
}