import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 251202_주몽{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int leftIdx = 0;
        int rightIdx = N - 1;
        while(leftIdx < rightIdx) {
            int sum = arr[leftIdx] + arr[rightIdx];

            if (sum == M) {
                cnt++;
                leftIdx++;
                rightIdx--;
            } else if(sum < M){
                leftIdx++;
            } else {
                rightIdx--;
            }

        }

        System.out.println(cnt);
    }
}