import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int pactorial(int k) {
        if (k==0)
            return 1;
        return ((int)Math.pow(2, k-1) + pactorial(k-1));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        sb.append((int)(Math.pow(2, K) - 1)).append('\n');
        
        path(K, 1, 2, 3);
        
        System.out.println(sb);
    }
    
    static void path(int n, int start, int mid, int to) {
        if (n == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }
        
        path(n-1, start, to, mid);
        
        sb.append(start + " " + to + "\n");
        
        path(n-1, mid, start, to);
    }
}