import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken()); // 총 게임 수
        long Y = Long.parseLong(st.nextToken()); // 이긴 게임 수

        long Z = (Y * 100) / X;

        // 승률이 99 이상이면 절대 변하지 않음
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = 1000000000L; // 상한
        long answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            long newZ = ((Y + mid) * 100) / (X + mid);

            if (newZ > Z) {
                answer = mid;
                right = mid - 1; // 더 작은 값 가능한지 확인
            } else {
                left = mid + 1;  // 더 많이 해야 승률이 오름
            }
        }

        System.out.println(answer);
    }
}
