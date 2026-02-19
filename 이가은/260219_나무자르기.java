import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        int[] trees = new int[n];
        int max = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int tree = Integer.parseInt(st.nextToken());
            trees[i] = tree;
            max = Math.max(max, tree);
        }

        int low = 0;
        int high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sum = 0;

            for (int tree : trees) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }

            if (sum >= m) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}