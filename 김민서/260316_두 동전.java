import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int x1, y1, x2, y2, depth;

        Node(int x1, int y1, int x2, int y2, int depth) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        List<int[]> coins = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'o'){
                    coins.add(new int[]{i,j});
                }
            }
        }

        int x1 = coins.get(0)[0];
        int y1 = coins.get(0)[1];
        int x2 = coins.get(1)[0];
        int y2 = coins.get(1)[1];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x1,y1,x2,y2,0));

        while(!q.isEmpty()){

            Node cur = q.poll();

            if(cur.depth >= 10) continue;

            for(int i = 0; i < 4; i++){

                int nx1 = cur.x1 + dx[i];
                int ny1 = cur.y1 + dy[i];
                int nx2 = cur.x2 + dx[i];
                int ny2 = cur.y2 + dy[i];

                boolean drop1 = false;
                boolean drop2 = false;

                if(nx1 < 0 || ny1 < 0 || nx1 >= n || ny1 >= m) drop1 = true;
                if(nx2 < 0 || ny2 < 0 || nx2 >= n || ny2 >= m) drop2 = true;

                if(drop1 && drop2) continue;

                if(drop1 || drop2){
                    System.out.println(cur.depth + 1);
                    return;
                }

                if(map[nx1][ny1] == '#'){
                    nx1 = cur.x1;
                    ny1 = cur.y1;
                }

                if(map[nx2][ny2] == '#'){
                    nx2 = cur.x2;
                    ny2 = cur.y2;
                }

                q.add(new Node(nx1, ny1, nx2, ny2, cur.depth + 1));
            }
        }

        System.out.println(-1);
    }
}