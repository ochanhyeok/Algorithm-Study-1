import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] home_arr = new int[n];

        for (int i = 0; i < n; i++) {
            home_arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home_arr);

        // 공유기 사이 거리 최솟값
        int min = 1;
        int max = home_arr[n - 1] - home_arr[0];

        while (min <= max) {
            int mid = min + (max - min) / 2;

            // 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에 첫 집부터 설치
            int cnt = 1;
            int prev = home_arr[0];

            for (int i = 1; i < n; i++) {
                if (home_arr[i] - prev >= mid) { 
                    prev = home_arr[i];
                    cnt++;
                }
            }

            if (cnt >= c) {    
                answer = mid;  
                min = mid + 1;  
            } else {
                max = mid - 1;
            }
        }

        System.out.println(answer);
    }
}