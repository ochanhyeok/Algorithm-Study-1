import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FindParent {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		answer = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph [a].add(b);
            graph[b].add(a); 
        }
        
        dfs(1);
        
		for(int i = 2; i <= n; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static void dfs(int start) {
		visited[start] = true;
        for (int next : graph[start]) {
            if (!visited[next]) {
            	answer[next] = start;
                dfs(next);
            }
        }
        
	}

}
