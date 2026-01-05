import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(fibo(N));
        
    }

    public static int fibo(int N){
        //0,1,1 그 다음부터 피보나치 수를 구할 수 았으니 0~2번째 처리 
        if(N==0) return 0;
        if(N==1 || N==2 ) return 1;
        return fibo(N-1) + fibo(N-2);
    }
}