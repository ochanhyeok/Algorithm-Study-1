import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        long gcd = divisor(a, b);
        
        StringBuilder answer = new StringBuilder("");
        for (long j=0; j<gcd; j++) {
            answer.append("1");
        }
        System.out.println(answer);
    }
    
    // A를 B로 나눈 나머지를 R이라고 할 때, A와 B의 최대공약수는 B와 R의 최대공약수와 같다.
    static long divisor(long a, long b) {
        if (b==0)
            return a;
        return divisor(b, a%b); 
    }
}
