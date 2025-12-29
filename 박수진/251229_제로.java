import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sum -= stack.pop();   // 최근 값 제거
            } else {
                stack.push(num);      // 최근 값 저장
                sum += num;
            }
        }

        System.out.println(sum);
    }
}
