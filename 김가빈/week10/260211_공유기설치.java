import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] houses = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			houses[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(houses);
		
		int start = 0, end = 1000000000;
		int answer = 0;
		int mid =0; 
		
		while (start <= end) {
			
			mid = (start + end)/2;
			int installCnt = 1;
			int prev = houses[0];
			
//			System.out.println("start="+start + " end="+end + " mid="+mid);
			for (int i=1; i<houses.length ; i++) {
				if (houses[i] - prev >= mid) {
					installCnt++;
					prev = houses[i];
				}
//				System.out.println("i= "+ i +" installCnt="+installCnt + " prev="+prev);
			}
			
			//설치개수 < C -> mid가 크니까 줄여야함. 
			if (installCnt < C) {
				end = mid-1; 
			} else {
				start = mid +1;
				answer = mid;
			}
		
		}
	
		System.out.println(answer);

	}
	
}

