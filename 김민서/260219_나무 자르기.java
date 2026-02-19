import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(trees); // end값을 위해
        
        int start = 0;
        int end = trees[N - 1];
        
        while(start <= end) {
            int mid = (start + end) / 2;
            long h = 0;
            
            for(int tree : trees) {
                if(tree >= mid){
                    h += tree - mid;
                }
            }
            
            if(h >= M) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
}