package gabeenKim.week1;

import java.util.*;
import java.io.*;
public class B1940 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start = 0, end = arr.length-1;
		int cnt = 0;
		while(start < end) {
			int sum = arr[start] + arr[end];
			
			if(sum > M ) end--;
			else if(sum < M) start++;
			else {
				cnt++;
				start++; 
				end--;
				
			}
		}
		
		System.out.println(cnt);
		
	}

}
