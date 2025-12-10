import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static boolean[] visited;
	static List<Integer>[] connections;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int answer = 0;
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		connections = new ArrayList[n+1];
		
		for (int i = 1; i <= n; i++) connections[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			connections[a].add(b);
			connections[b].add(a);
		}
		
		for (int i = 1; i <= n; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			dfs(i);
			answer++;
		}
		
		System.out.println(answer);
	}
	
	static void dfs(int node) {
		for (int next: connections[node]) {
			if (visited[next]) continue;
			visited[next] = true;
			dfs(next);
		}
	}

}