import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] length = new int[N];
        int total_length = 0;
        int max = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            length[i] = Integer.parseInt(st.nextToken());
            total_length += length[i];
            if (length[i] > max) max = length[i];
        }
        
        long left = max; // 블루레이 하나가 가질 수 있는 최소 가능 용량 (가장 긴 영상 하나의 길이)
        long right = total_length; // 최대 필요 용량 (최악의 경우, 모든 영상 길이의 합)
        long answer = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            int cnt = 1; // 현재 mid로 강의를 담을 때, 필요한 블루레이 개수
            long curr = 0; // 현재 사용중인 블루레이에 들어간 강의 길이의 합
            
            for (int i = 0; i < N; i++) {
                if (curr + length[i] > mid) {
                    cnt++;
                    curr = length[i];
                } else {
                    curr += length[i];
                }
            }
            
            if (cnt <= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
}