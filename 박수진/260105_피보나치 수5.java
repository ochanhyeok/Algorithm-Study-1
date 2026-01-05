import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        int[] arr = new int[n+1];

        for (int i = 0; i <= n; i++){
            if (i == 0) {
                arr[i] = 0;
            } else if (i == 1) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
        
        System.out.println(arr[n]);
    }
}