import java.util.*;
import java.io.*; 

public class Main {
    static int N, M;
    static char[][] board; 
    static boolean[][][][] visited;    //방문한 위치 좌표 
    
    static int[] dx = {-1,1,0,0}; 
    static int[] dy = {0,0,-1,1};
    
    static class State {
        int x1, y1, x2, y2, cnt; 
        
        State(int x1, int y1, int x2, int y2, int cnt){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.cnt = cnt; 
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new char[N][M];
        visited = new boolean[N][M][N][M]; 
        
        List<int[]> coins = new ArrayList<>(); 
        
        for(int i=0; i<N;i++){
            String line = br.readLine(); 
            for(int j=0; j<M; j++){
                board[i][j] = line.charAt(j); 
                if(board[i][j] == 'o'){
                    coins.add(new int[]{i,j}); 
                    board[i][j] = '.'; //동전 위치는 빈칸처럼 처리 
                }
            }
        }
        
        int x1 = coins.get(0)[0]; 
        int y1 = coins.get(0)[1]; 
        int x2 = coins.get(1)[0];
        int y2 = coins.get(1)[1];
        
        System.out.println(bfs(x1,y1,x2,y2));
    }
    
    static int bfs(int x1, int y1, int x2, int y2){
        Queue<State> q = new LinkedList<>();
        //동전 위치 큐에 넣어주기
        q.offer(new State(x1,y1,x2,y2,0));
        //해당 좌표 방문처리
        visited[x1][y1][x2][y2] = true;
        
        while(!q.isEmpty()){
            State cur = q.poll();
            
            //10번 움직인 거면 X 
            if(cur.cnt >= 10) continue; 
            
            for(int dir =0; dir<4; dir++){
                int nx1 = cur.x1 + dx[dir]; 
                int ny1 = cur.y1 + dy[dir]; 
                int nx2 = cur.x2 + dx[dir]; 
                int ny2 = cur.y2 + dy[dir]; 
                
                //다음 좌표 상으로 동전이 떨어지는지 아닌지 확인
                boolean out1 = isOut(nx1, ny1); 
                boolean out2 = isOut(nx2, ny2); 
                
                if (out1 && out2) continue; 
                if (out1 || out2) return cur.cnt + 1; 
                if (board[nx1][ny1] == '#') {
                    nx1 = cur.x1;
                    ny1 = cur.y1; 
                }
                if (board[nx2][ny2] == '#'){
                    nx2 = cur.x2;
                    ny2 = cur.y2; 
                }
                
                if(!visited[nx1][ny1][nx2][ny2]){
                    visited[nx1][ny1][nx2][ny2] = true; 
                    q.offer(new State(nx1, ny1, nx2, ny2, cur.cnt+1));
                }
        }
        return -1; 
    }
    
    static boolean isOut(int x, int y){
        return x <0 || x >= N || y < 0 || y >= M;
    }
}