import java.util.*;
import java.io.*;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        long[] prefix = new long[N + 1]; // 누적합
        
        for (int i=1; i<=N; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            long result = prefix[end] - prefix[start - 1];
            answer.append(result).append('\n');
        }
        
        System.out.println(answer);
    }
}