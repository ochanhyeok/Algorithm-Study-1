import java.util.*;
import java.io.*;

class Main{
    static int[][][] tomatoes;
    static int[] dz = {1,-1,0,0,0,0}; //위아래
    static int[] dx = {0,0,-1,1,0,0}; //왼오
    static int[] dy = {0,0,0,0,1,-1}; //앞뒤
    static int N, M, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoes = new int[H][N][M]; //층행열
        Queue<int[]> queue = new ArrayDeque();

        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                for(int m=0; m<M; m++){
                    tomatoes[h][n][m] = Integer.parseInt(st.nextToken());
                    if(tomatoes[h][n][m] == 1) queue.offer(new int[]{h,n,m});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int d=0; d<6; d++){
                int nz = cur[0] + dz[d];
                int ny = cur[1] + dy[d];
                int nx = cur[2] + dx[d];

                if ( nz<0 || ny<0 || nx<0 ||
                        nz>=H || ny>=N || nx>=M ) continue;
                if (tomatoes[nz][ny][nx] == 0){
                    //1일차, 2일차, 3일차 ... 날짜 더해가며 구하면 중복체크 안 해도 됨.
                    tomatoes[nz][ny][nx] = tomatoes[cur[0]][cur[1]][cur[2]] + 1;
                    queue.offer(new int[]{nz,ny,nx});
                }
            }
        }

        int answer = 0;
        int cnt = 0;
        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(tomatoes[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    if(tomatoes[h][n][m] != -1){
                        answer = Math.max(answer,tomatoes[h][n][m]);
                    }
                }
            }
        }
        System.out.println(answer-1);
    }
}