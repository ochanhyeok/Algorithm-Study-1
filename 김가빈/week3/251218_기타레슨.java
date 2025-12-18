package task;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		int sum = 0; // 전체 강의 길이의 합
		int maxLen = 0; //가장 긴 강의의 길이
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i< N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			maxLen = Math.max(maxLen, arr[i]);					
		}
		
		//이진탐색 범위 지정 
		//시작값이 가장 긴 강의의 길이, 종료 값이 전체 강의 길이의 합. 
		int start = maxLen;
		int end = sum; 
		
		int answer = sum; //정답 저장용 
		
		while(start <= end ) {
			//중간 값
			int mid = (start+end) /2 ; 
			
			int cnt =1;//현재 중간 값으로 나눴을 때 필요한 블루레이 개수 카운팅할 변수
			int curSum =0;
			
			//강의를 하나씩 mid 용량에 나눠서 담아보기 
			for(int i=0; i<N; i++) {
				//현재 블루레이에 넣을 수 있으면 누적
				if(curSum + arr[i] <= mid) {
					curSum += arr[i];
				} else { 
					//넘치면 새로운 블루레이를 하나 더 쓰고
					cnt++;
					curSum = arr[i];
				}
			}
			
			//필요한 블루레이 수가 M개 이하라면 중간 값으로 정한 용량도 가능하니까 중간값 갱신
			if(cnt <=M) {
				answer = mid;
				end = mid -1; //범위를 중간 값 앞으로
			} else { //M보다 많으면 용량이 작은 거니까 늘려 
				start = mid +1 ;
			}
			
		}
		System.out.println(answer);
	}
}

