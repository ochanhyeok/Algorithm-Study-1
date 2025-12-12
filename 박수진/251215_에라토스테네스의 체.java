import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] numbers = new int[N+1];
        int cnt = 0;
        for (int idx=2; idx<=N; idx++) {
            if (numbers[idx] == 0 && isPrime(idx)) {
                numbers[idx] = 1;
                cnt++;
                if (cnt == K)
                    System.out.println(idx);
                
                int iter = idx;
                int x = 2;
                while(iter*x <= N) {
                    if (numbers[iter*x] == 0) {
                        numbers[iter*x] = 1;
                        cnt++;
                        if (cnt == K)
                            System.out.print(iter * x);
                    }
                    x++;
                }
            }
        }
    }
    
    static boolean isPrime(int i) {
        if (i<2)
            return false;
        for (int j=2; j<=(int)Math.sqrt(i); j++) {
            if (i%j == 0)
                return false;
        }
        return true;
    }
}