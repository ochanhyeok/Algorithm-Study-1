import java.util.*;
import java.io.*;

class Main {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());

        long Z = (Y * 100) / X ;
        if(Z >= 99 ){
            System.out.println(-1);
            return;
        }

        long start = 1; 
        long end = 1000000000L;
        long mid = 0;
        long count = 0; 
        
        while(start<= end){
            mid = (start + end)/2;
            long newRate = (Y + mid)*100 / (X+mid);

            if (newRate < Z){
                start = mid + 1; 
            } else {
                end = mid - 1;
                count = mid;
            }
        }
        System.out.println(count);
    }
}