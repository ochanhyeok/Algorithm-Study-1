import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static double[] per = new double[4];
    static boolean[][] visited = new boolean[30][30];

    static int n;
    static double answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 4; i++){
            per[i] = Integer.parseInt(st.nextToken()) / 100.0;
        }

        visited[15][15] = true;
        dfs(15, 15, 0, 1.0);

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int depth, double prob){

        if(depth == n){
            answer += prob;
            return;
        }

        for(int i = 0; i < 4; i++){

            if(per[i] == 0) continue;

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!visited[nx][ny]){

                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, prob * per[i]);
                visited[nx][ny] = false;
            }
        }
    }
}