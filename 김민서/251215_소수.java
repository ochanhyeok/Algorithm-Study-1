import java.util.*;
import java.io.*;

public class Main{
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int min = 0;
        int sum = 0;
        for(int i = m; i>=n; i--){
            if(find(i)){
                min = i;
                sum += i;
            }
        }
        if(sum==0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);    
        }
    }
    public static boolean find(int n){
        if(n<2) return false;
        for(int i = 2; i<=n/2; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}