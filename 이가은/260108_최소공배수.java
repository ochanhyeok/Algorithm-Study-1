import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(solve(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    static int solve(int a, int b) {
        int m = Math.min(a, b);
        int gcd = 1;
        for (int j = m; j > 0; j--) {
            if (a % j == 0 && b % j == 0) {
                gcd  = j;
                break;
            }
        }
        return a * b / gcd;
    }
}