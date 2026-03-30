import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();
    static boolean[] selected;
    static int answer = Integer.MAX_VALUE;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (value == 1) {
                    houses.add(new Point(i, j));
                } else if (value == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        selected = new boolean[chickens.size()];
        comb(0, 0);

        System.out.println(answer);
    }

    static void comb(int start, int count) {
        if (count == M) {
            answer = Math.min(answer, getCityChickenDistance());
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[i] = true;
            comb(i + 1, count + 1);
            selected[i] = false;
        }
    }

    static int getCityChickenDistance() {
        int total = 0;

        for (Point house : houses) {
            int minDist = Integer.MAX_VALUE;

            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    Point chicken = chickens.get(i);
                    int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                    minDist = Math.min(minDist, dist);
                }
            }

            total += minDist;
        }

        return total;
    }
}