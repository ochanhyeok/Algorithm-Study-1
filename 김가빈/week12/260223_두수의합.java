import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr); 
        int s = 0, e = n-1;
        int sum = arr[s] + arr[e];
        int cnt = 0;

        while (s < e){            
            if (sum < x ){
                sum -= arr[s++];
                sum += arr[s];
            } else if (sum > x){
                sum -= arr[e--];
                sum += arr[e];
            } else {
                cnt++;
                sum -= (arr[s]+arr[e]);
                s++; e--;
                sum += (arr[s]+arr[e]);
            }
        }
        System.out.println(cnt);
     }
}