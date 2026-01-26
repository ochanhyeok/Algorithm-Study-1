import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
       
        int z = (int) ((y * 100.0) / x);
        
        if(z >= 99) {
            System.out.println(-1);
            return;
        }

        
        long start = 1;
        long end = 2_000_000_000L;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            int rate = (int) (( (y + mid) * 100.0 ) / (x + mid));
            
            if(z < rate) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        System.out.println(start);
        
    }
}