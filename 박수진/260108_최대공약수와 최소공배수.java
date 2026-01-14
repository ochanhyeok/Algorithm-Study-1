import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        lcm(a, b);
        return;
    }
    
    // least common multiple
    static void lcm(int a, int b) {
        int max = a >= b ? a : b;
        int min = a >= b ? b : a;
        
        int ans = 0;
        for (int i = min; i >= 1; i--) {
            if (min%i == 0 && max%i == 0) {
                ans = i;
                break;
            }
        }
        
        System.out.println(ans);
        
        if (ans != 0)
            System.out.println((a*b)/ans);
        else
            System.out.println(a*b);
    }
}