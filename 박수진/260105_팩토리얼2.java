import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        
        long answer = 1L;
        for (int i = 2; i <= N; i++) {
            answer *= i;
        }
        
        System.out.println(answer);
    }
}