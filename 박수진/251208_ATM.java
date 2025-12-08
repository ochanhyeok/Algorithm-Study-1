import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String P = br.readLine();
        
        int[] pI = Arrays.stream(P.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(pI);
        
        int answer = 0;
        for (int i=0; i<=N-1; i++) {
            answer += (N-i) * pI[i];
        }
        
        System.out.println(answer);
    }
}