import java.util.*;
import java.io.*;

public class Main{
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long temp = 0;
        while(b != 0){ 
            temp = b;  
            b = a%b;       
            a = temp;     
        }
        StringBuilder sb = new StringBuilder();
        for(long i = 0; i < a; i++){
            sb.append('1');
        }
        System.out.println(sb.toString());
	}
}