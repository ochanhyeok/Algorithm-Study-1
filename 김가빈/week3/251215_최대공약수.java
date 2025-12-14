package week1.array;

import java.util.*;
import java.io.*;

public class Main {
	public static long gcd(long A, long B) {
		if(B==0) return A;
		return gcd(B, A%B);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력되는 수는 263보다 작은 자연수이므로 long(-2^63~2^63-1)으로 지정
		long cntA = Long.parseLong(st.nextToken());
		long cntB = Long.parseLong(st.nextToken());
		
		long gcdNum = gcd(cntA, cntB);
		//long으로 지정했더니 출력이 넘치는 경우 발생. 따라서 StringBuilder로 이어 붙여줌
		//Strig의 경우 매번 새로운 객체가 생겨나서 시간초과 발생
		StringBuilder sb = new StringBuilder(); 
		
		for (long i=0; i<gcdNum; i++) {
			sb.append(1);
		}
		System.out.println(sb.toString());
		
	}
	

}
