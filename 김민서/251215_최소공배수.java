import java.util.*;
import java.io.*;

public class Main{
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println((a*b)/mx(a,b));
	}
    public static long mx(long a, long b){
        long temp = 0;
        while(b != 0){ 
            temp = b;  
            b = a%b;       
            a = temp;     
        } 
        return a;
    }
}