import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<String> answer = new ArrayList<>();
	static int N;
	static int R;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		for (int num = 1; num <= N; num++) {
			StringBuilder sb = new StringBuilder();
			sb.append(num);
			boolean[] visited = new boolean[10];
			visited[num] = true;
			comb(num, 1, sb, visited);
		};
		
		for (String str: answer) System.out.println(str);
	}
	
	static void comb(int num, int r, StringBuilder temp, boolean[] visited ) {
		
		if ( r == R ) {
			answer.add(temp.toString());
			return;
		}
		
		
		for (int next = 1; next <= N; next++) {
			if (visited[next]) continue;
			StringBuilder sb = new StringBuilder(temp);
			boolean[] nextVisited = visited.clone();
			nextVisited[next] = true;
			sb.append(" " + next);
			comb(next, r + 1, sb, nextVisited);
		}
		
	}

}