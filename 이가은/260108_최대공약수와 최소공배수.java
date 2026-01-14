import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(solve(a, b));

    }

    static String solve(int a, int b) {
        int m = Math.min(a, b);
        int gcd = 1;
        for (int j = m; j > 0; j--) {
            if (a % j == 0 && b % j == 0) {
                gcd  = j;
                break;
            }
        }
        return gcd + "\n" + a * b / gcd;
    }
}