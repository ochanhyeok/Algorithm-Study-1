import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int[] router = new int[N];
        for (int i = 0; i < N; i++) {
            router[i] = Integer.parseInt(bf.readLine());
        }
        
        Arrays.sort(router);
        
        int left = 0;
        int right = router[N-1];
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if(keepMid(router, C, mid, router[N-1] - router[0])) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
    
    static boolean keepMid(int[] router, int C, int mid, int distance) {
        int cnt = 1;
        int prev = router[0];
        
        for (int r : router) {
            if (r - prev >= mid) {
                cnt++;
                prev = r;
                if (cnt >= C) return true;
            }
        }
        
        return false;
    }
}