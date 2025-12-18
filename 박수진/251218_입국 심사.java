import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        long[] t = new long[N];
        long maxT = 0;
        for (int i = 0; i < N; i++) {
            t[i] = Long.parseLong(br.readLine().trim());
            maxT = Math.max(maxT, t[i]); 
        }
        
        long left = 0;
        long right = maxT * M; // 가장 느린 심사관이 M명을 전부 처리 (최악의 상황)
        long answer = right;
        
        while (left <= right) {
            long mid = (left + right) / 2; // 심사에 사용할 시간
            
            long cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += mid / t[i];
                if (cnt >= M) {
                    break;
                }
            }
            
            if (cnt >= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
}