package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE {

	static List<Integer>[] adj;
	static int N;
	static int M;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new List[N];

		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}

		visited = new boolean[N];

		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if (dfs(i, 0)) {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static boolean dfs(int now, int depth){
		if (depth == 4) {
			return true;
		}

		visited[now] = true;
		for (int next : adj[now]) {
			if (!visited[next]) {
				if (dfs(next, depth + 1)) {
					visited[now] = false;
					return true;
				}
			}
		}
		visited[now] = false;
		return false;
	}
}
