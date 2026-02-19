import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    static long[][] dp = new long[20][4];
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine().trim());
        
        // 1. DP 테이블 채우기
        // dp[i][j] (i=남은 자리 개수, j='6' 연속 횟수 0~3)
        dp[0][3] = 1; // 0자리 남았고, 이미 666
        for (int i = 1; i < 20; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k <= 9; k++) {
                    int nextState;
                    if (j == 3) nextState = 3;
                    else if (k == 6) nextState = j + 1;
                    else nextState = 0;
                    
                    dp[i][j] += dp[i - 1][nextState];
                }
            }
        }
        
        // 2. 결과 숫자의 자릿수 결정
        int length = 3;
        while(true) {
            long cnt = 0;
            for (int i = 1; i <= 9; i++) {
                cnt += dp[length - 1][(i == 6) ? 1 : 0];
            }
            if (N <= cnt) break;
            N -= cnt;
            length++;
        }
        
        // 3. 자릿수별로 숫자 복원 (greedy)
        StringBuilder sb = new StringBuilder();
        int currentState = 0;
        
        for (int i = length; i >= 1; i--) {
            int start = (i == length) ? 1 : 0;
            for (int k = start; k <= 9; k++) {
                int nextState;
                if (currentState == 3) nextState = 3;
                else if (k == 6) nextState = currentState + 1;
                else nextState = 0;
                
                long count = dp[i - 1][nextState];
                
                if (N <= count) {
                    sb.append(k);
                    currentState = nextState;
                    break;
                } else {
                    N -= count;
                }
            }
        }
        
        System.out.println(sb.toString());
    }
}
