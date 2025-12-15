import java.util.*;
import java.io.*;

public class Main{
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] output;
	public static void main(String args[]) throws Exception{
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        output = new int[r];
        p(0, n, r);
        System.out.println(sb.toString());
	}
    
    public static void p(int dept, int n, int r){
        if(dept == r){
            for(int i = 0; i < r; i++){
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int j=0; j<n; j++){
            if(!visited[j]){
                visited[j] = true;
                output[dept]= j+1;
                p(dept+1, n, r);
                visited[j] = false;
            }
        }
    }
}