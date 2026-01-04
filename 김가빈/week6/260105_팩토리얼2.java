import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		System.out.println(factorial(1,N));
		
	}
	
	public static long factorial(int depth, int N) {
        //N이 0일 때도 처리해줘야 함.(입력조건)
		if(N==0) return 1;
		if(depth == N) return N;
		return depth*factorial(depth+1, N);
	}

}
