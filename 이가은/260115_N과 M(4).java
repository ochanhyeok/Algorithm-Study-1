import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            comb(1, i, sb);
        }

        System.out.println(answer.substring(0, answer.length() - 1));

    }

    static void comb(int length, int start, StringBuilder current) {

        if (length == m) {
            answer.append(current).append('\n');
            return;
        }

        for (int i = start; i <= n; i++) {

            StringBuilder next = new StringBuilder(current);
            next.append(" ").append(i);

            comb(length + 1, i, next);
        }
    }

}