import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] trees = new int[N];
      
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N ;i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }
        
        int start=0, end= 1000000000;
        int answer =0; 
        
        while (start<=end){
            int height = (start+end) /2;
            long totalSum = 0;
            
            for (int t : trees) {
                if (t > height) totalSum += (t - height);
            }
           
            if (totalSum < M) {
                end = height-1;
            } else if (totalSum >= M) {
                start = height+1;
                answer = height;
            }
        }
        
        System.out.println(answer);
    }
}