import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;

        int[] cards = new int[n];

        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if (cards[i] == cards[j]) continue;
                for (int k = j + 1; k < n; k++) {
                    if (cards[i] == cards[k] || cards[j] == cards[k]) continue;
                    int sum = cards[i] + cards[j] + cards[k];

                    if (sum > m) continue;

                    answer = Math.max(answer, sum);
                }
            }
        }
        System.out.println(answer);

    }
}