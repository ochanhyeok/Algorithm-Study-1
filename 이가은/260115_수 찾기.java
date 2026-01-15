import java.io.*;
import java.util.*;

public class Main {
    static int binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] == x) return 1;
            if (arr[mid] < x) l = mid + 1;
            else r = mid - 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(arr, x)).append('\n');
        }
        System.out.print(sb);
    }
}
