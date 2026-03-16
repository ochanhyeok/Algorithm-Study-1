import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int max = 0;
        
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(i == j || i == k || j == k) continue;
                    
                    int sum = nums[i] + nums[j] + nums[k];
                        
                    if(sum == m) {
                        System.out.println(sum);
                        return;
                    } else if (sum < m && sum > max) {
                        max = sum;
                    }
                }
            }
        }
        
        System.out.println(max);
    }
}