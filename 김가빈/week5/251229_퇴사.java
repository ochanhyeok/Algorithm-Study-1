import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,ans;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][2];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<2;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans=0;
		dfs(1,0);
		System.out.println(ans);
	}
	
	public static void dfs(int n,int p) {
		if(n>N+1) return;
		if(n==N+1){
			ans = Math.max(ans, p);
			return;
		}
		
		
		dfs(n+arr[n][0],p+arr[n][1]);
		dfs(n+1,p);
	}
}
