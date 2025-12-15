import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Dfs {
	static List<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph [a].add(b);
            graph[b].add(a); 
        }
        
        int cnt = 0;
        for(int j=1; j <=n; j++) {
        	if(!visited[j]) {
        		dfs(j);
        		cnt++;
        	}
        }
		System.out.println(cnt);
	}
	
	public static void dfs(int start) {
		visited[start] = true;
        for (int next : graph[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
        
	}

}
