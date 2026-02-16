import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine().trim());

        for (long prefix = 0; ; prefix++) {
            int from, to;

            // prefix ..666, suffix: 세 자리 숫자 다 가능
            if (contains666(prefix)) { 
                from = 0;   to = 999;
            } 
            
            // prefix ..66, suffix 6__
            else if (prefix % 100 == 66) {
                from = 600; to = 699;
            } 
            
            // prefix ..6, suffix 66_
            else if (prefix % 10 == 6) {
                from = 660; to = 669;
            } 
            
            // suffix 666
            else {
                from = 666; to = 666;
            }

            // 이번 prefix에서 만들어지는 종말의 수 개수
            long cnt = (long) to - from + 1; 

            if (N - cnt > 0) { // 아직 N번째 도달 X
                N -= cnt; // 만든 만큼 빼기
            } else {
                // (N-1)번째 선택
                long suffix = from + (N - 1);
                long ans = prefix * 1000L + suffix;
                System.out.println(ans);
                return;
            }
        }
    }

    // prefix 666 포함 여부
    private static boolean contains666(long num) {
        while (num >= 666) {
            if (num % 1000 == 666) return true;
            num /= 10;
        }
        return false;
    }
}
