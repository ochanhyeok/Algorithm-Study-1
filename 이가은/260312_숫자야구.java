import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] hints = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            hints[i][0] = Integer.parseInt(st.nextToken()); // 질문 숫자
            hints[i][1] = Integer.parseInt(st.nextToken()); // strike
            hints[i][2] = Integer.parseInt(st.nextToken()); // ball
        }

        int answer = 0;

        for (int num = 123; num <= 987; num++) {
            String candidate = String.valueOf(num);

            // 0 포함 불가
            if (candidate.charAt(0) == '0' || candidate.charAt(1) == '0' || candidate.charAt(2) == '0') {
                continue;
            }

            // 중복 숫자 불가
            if (candidate.charAt(0) == candidate.charAt(1) ||
                    candidate.charAt(1) == candidate.charAt(2) ||
                    candidate.charAt(0) == candidate.charAt(2)) {
                continue;
            }

            boolean possible = true;

            for (int i = 0; i < n; i++) {
                String target = String.valueOf(hints[i][0]);

                int strike = 0;
                int ball = 0;

                for (int j = 0; j < 3; j++) {
                    if (candidate.charAt(j) == target.charAt(j)) {
                        strike++;
                    }
                }

                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (j != k && candidate.charAt(j) == target.charAt(k)) {
                            ball++;
                        }
                    }
                }

                if (strike != hints[i][1] || ball != hints[i][2]) {
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