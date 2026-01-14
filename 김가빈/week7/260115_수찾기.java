import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N;n++) arr[n]= Integer.parseInt(st.nextToken());
	
		int M = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<M;n++) {
            //찾을 숫자
			int target  = Integer.parseInt(st.nextToken());
			//탐색 범위의 양 끝 설정
            int start=0, end=N-1;
			while(start<=end) {
				int m = (start+end)/2;    //중간값 설정
				if(arr[m]==target) {      //중간값이 타켓일때
					System.out.println(1);
					break;
				}
				if(arr[m]>target) end = m-1; //중간값이 타켓보다 크면 end를 중간값 -1호
				if(arr[m]<target) start =m+1;//작다면 시작값을 중간값+1로
			}
			if(start>end)System.out.println(0);
		}
		
	}

}
