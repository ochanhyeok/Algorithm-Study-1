package task;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//정렬 후 탐색해야 빨리 찾을 수 있을 것 같아서 일단 해줌. 
		Arrays.sort(arr);
		
//		System.out.println(Arrays.toString(arr));
		int cnt =0; 
		//배열을 순회하면서 서로 다른 두 수의 합이 배열 안에 들어 있는지 확인 할 것. 
		for(int i=0; i<arr.length; i++) {
			int target = arr[i];//찾을 숫자
			int start = 0, end= arr.length-1;
			//투포인터 
			while(start<end) {
				//target 자기 자신을 합에 써버리는 경우를 걸러주지 않아서 틀림 => 서로 다른 두 수여야 하기 때문에. 
				if(i==start) {
					start++;
					continue;
				}
				if(i==end) {
					end--;
					continue;
				}
				//현재 오름차순인데 s랑e 더해서 타겟보다(i=0부터시작) 크면 e를 좁혀서 범위를 줄여야 함.
				if( arr[start] +arr[end] >target) {
					end--;
				} else if ( arr[start] +arr[end] == target) {
					cnt++;
					end--;
					start++;
					break;
				} else {
					start++;
				}
			}
			
		}
		
		System.out.println(cnt);
		
	}
}

