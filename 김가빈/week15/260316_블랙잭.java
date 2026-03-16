import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }
    
    static void dfs(int idx, int count, int sum) {
        if(count == 3 ){
            if(sum <= M) {
                //최대한 M에 가깝게
                answer = Math.max(answer, sum);    
            }
            return;
        } 
        
        //고른 카드에서부터 뽑기 
        for(int i=idx; i<N; i++){
            dfs(i+1, count+1, sum + arr[i]);
        }
    }
}