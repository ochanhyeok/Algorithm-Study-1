package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    houses.add(new int[]{y, x});
                } else if (num == 2) {
                    chickens.add(new int[]{y, x});
                }
            }
        }

        comb(M, 0, new ArrayList<>());

        System.out.println(answer);
    }

    static void comb(int r, int start, List<int[]> current) {
        if (r == 0) {
            answer = Math.min(answer, getCityChickenDistance(current));
            return;
        }

        for (int j = start; j <= chickens.size() - r; j++) {
            current.add(chickens.get(j));
            comb(r - 1, j + 1, current);
            current.remove(current.size() - 1);
        }
    }

    static int getCityChickenDistance(List<int[]> selectedChickens) {
        int total = 0;

        for (int[] house : houses) {
            int minDist = Integer.MAX_VALUE;

            for (int[] chicken : selectedChickens) {
                int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                minDist = Math.min(minDist, dist);
            }

            total += minDist;
        }

        return total;
    }
}