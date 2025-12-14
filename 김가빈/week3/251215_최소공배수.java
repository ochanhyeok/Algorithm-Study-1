package week1.array;

import java.util.*;
import java.io.*;

public class Main {
	public static long gcd(long A, long B) {
		if(B==0) return A;
		return gcd(B, A%B);
	}
	
	public static long lcm(long A, long B) {
		return (A * B)/gcd(A,B);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		System.out.println(lcm(A,B));
	}
	

}
