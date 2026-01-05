import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] value = new int[N]; 
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }
        
        int answer = 0;
        for (int i = N-1; i >= 0; i--) {
            if (K/value[i] == 0) {
                continue;
            }
            answer += K/value[i];
            K -= value[i] * (K/value[i]);
            
            if (K == 0) {
                System.out.println(answer);
            }
        }
        return;
    }
}