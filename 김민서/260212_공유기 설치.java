import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[] p = new int[n];
        for(int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(p);
        
        int start = 1;
        int end = p[n - 1] - p[0];
        
        while (start <= end) {
            int prev = p[0];
            int cnt = 1;
            int mid = (start + end) / 2;
            
            for(int i = 1; i < n; i++) {
                if(p[i] - prev >= mid) {
                    prev = p[i];
                    cnt++;
                }
            }
            
            if (cnt < c) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        System.out.println(end);
    }
}