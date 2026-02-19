import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] tree = new int[N];
        int max = 0;
        
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i] > max) max = tree[i];
        }
        
        long start = 0;
        long end = max;
        long result = 0;
        
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            
            for (int t : tree) {
                if (t > mid) {
                    sum += (t - mid);
                }
            }
            
            if (sum >= M) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}
