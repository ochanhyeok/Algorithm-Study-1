import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
    static int[] A;
    
    // 이진 탐색 (정렬 활용)
    static int binarySearch(int x) {
        int l = 0, r = A.length - 1;
        while(l <= r) {
            int mid = (l + r) >>> 1;
            if (A[mid] == x) return 1;
            if (A[mid] < x) l = mid + 1;
            else r = mid - 1;
        }
        return 0;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        A = new int[N];
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);

        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            ans.append(binarySearch(x)).append('\n');
        }
        
        System.out.println(ans.toString());
    }
}