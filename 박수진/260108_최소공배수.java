import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lcm(a, b)).append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
    // least common multiple
    static int lcm(int a, int b) {
        if (a == b) {
            return a;
        }
        
        int max = a >= b ? a : b;
        int min = a >= b ? b : a;
        
        int ans = 0;
        for (int i = min; i >= 1; i--) {
            if (min%i == 0 && max%i == 0) {
                ans = i;
                break;
            }
        }
        
        if (ans != 0)
            return (a*b)/ans;
        else 
            return (a*b);
    }
}