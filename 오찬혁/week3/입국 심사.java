import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 입국심사 {

    static int N;
    static long M;
    static long[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N개의 심사대
        M = Long.parseLong(st.nextToken()); // M명의 사람
        times = new long[N];
        long maxTime = 0;

        for (int i = 0; i < N; i++) {
            // 해당 심사대가 한명 처리하는데 걸리는 시간
            times[i] = Long.parseLong(br.readLine());
            if(times[i] > maxTime){
                maxTime = times[i];
            }
        }

        long left = 0;
        long right = maxTime * M;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += mid / times[i];
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
