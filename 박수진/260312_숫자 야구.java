import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] nums = new int[N];
        int[] strikes = new int[N];
        int[] balls = new int[N];
        
        StringTokenizer st;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
            strikes[i] = Integer.parseInt(st.nextToken());
            balls[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int candidate = 123; candidate <= 987; candidate++) {
            String c = String.valueOf(candidate);

            // 0 포함 불가
            if (c.charAt(0) == '0' || c.charAt(1) == '0' || c.charAt(2) == '0') {
                continue;
            }

            // 숫자 중복 불가
            if (c.charAt(0) == c.charAt(1) || c.charAt(1) == c.charAt(2) || c.charAt(0) == c.charAt(2)) {
                continue;
            }

            boolean possible = true;

            for (int i = 0; i < N; i++) {
                String q = String.valueOf(nums[i]);

                int s = 0;
                int b = 0;

                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (c.charAt(x) == q.charAt(y)) {
                            if (x == y) s++;
                            else b++;
                        }
                    }
                }

                if (s != strikes[i] || b != balls[i]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}