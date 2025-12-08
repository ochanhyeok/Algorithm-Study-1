package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 2, 3);
    }

    static void hanoi(int n, int from, int via, int to) {
        if(n == 1){
            System.out.println(from + " " + to);
            return;
        }

        hanoi(n - 1, from, to, via);
        System.out.println(from + " " + to);
        hanoi(n - 1, via, from, to);
    }
}
