import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		int cnt = 0;
		
		for(int n=0; n<N;n++) {
			st = new StringTokenizer(br.readLine());
			arr[n]=Integer.parseInt(st.nextToken());
		}
		//동전 단위가 큰 것부터 구성해야 최솟값 나옴. 
        //배열의 뒤에서부터 순회하면서 해당 단위가 K보다 작을 때 몇개 사용해야 하는지 구하고 K에서 그 가격만큼 뺌. 
		for(int i=N-1;i>=0;i--) {
			if(arr[i]<=K) {
				cnt += (K/arr[i]);
				K %=arr[i];
			
			}
		}
		System.out.println(cnt);
	}

}
