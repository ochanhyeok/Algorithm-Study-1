import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int sharkX, sharkY;
    static int sharkSize = 2;
    static int eatCount = 0;
    static int time = 0;

    static int[] dx = {-1, 0, 0, 1}; // 상, 좌, 우, 하
    static int[] dy = {0, -1, 1, 0};

    static class Node {
        int x, y, dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static class Fish implements Comparable<Fish> {
        int x, y, dist;

        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish other) {
            if (this.dist != other.dist) return this.dist - other.dist;
            if (this.x != other.x) return this.x - other.x;
            return this.y - other.y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Fish target = bfs();
            if (target == null) break;

            sharkX = target.x;
            sharkY = target.y;
            time += target.dist;

            map[sharkX][sharkY] = 0;
            eatCount++;

            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);
    }

    static Fish bfs() {
        boolean[][] visited = new boolean[n][n];
        Queue<Node> q = new LinkedList<>();
        List<Fish> fishList = new ArrayList<>();

        q.offer(new Node(sharkX, sharkY, 0));
        visited[sharkX][sharkY] = true;

        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.dist > minDist) continue;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;
                int nextDist = cur.dist + 1;

                if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
                    fishList.add(new Fish(nx, ny, nextDist));
                    minDist = nextDist;
                }

                q.offer(new Node(nx, ny, nextDist));
            }
        }

        if (fishList.isEmpty()) return null;

        Collections.sort(fishList);
        return fishList.get(0);
    }
}