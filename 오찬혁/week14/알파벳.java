package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {

	static Character[][] boards;
	static boolean[] visited = new boolean[26];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int R, C, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		boards = new Character[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				boards[i][j] = line.charAt(j);
			}
		}

		visited[boards[0][0] - 'A'] = true;
		dfs(0, 0, 1);

		System.out.println(max);
	}

	static void dfs(int x, int y, int cnt) {
		max = Math.max(cnt, max);

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
				int alpha = boards[nx][ny] - 'A';
				if (!visited[alpha]) {
					visited[alpha] = true;
					dfs(nx, ny, cnt + 1);
					visited[alpha] = false;
				}
			}
		}
	}
}
