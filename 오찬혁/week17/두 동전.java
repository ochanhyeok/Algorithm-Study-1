import java.io.*;
import java.util.*;

public class Main{

	static int N, M;
	static char[][] grid;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		grid = new char[N][M];
		List<int[]> coins = new ArrayList<>();
		for(int i = 0; i < N; i++){
			String line = br.readLine();
			for(int j = 0; j < M; j++){
				grid[i][j] = line.charAt(j);
				if(grid[i][j] == 'o'){
					coins.add(new int[]{i, j});
				}
			}
		}

		int result = bfs(coins.get(0)[0], coins.get(0)[1], coins.get(1)[0], coins.get(1)[1], 0);
		System.out.println(result);
	}

	static int bfs(int r1, int c1, int r2, int c2, int step){
		Queue<int[]> q = new LinkedList<>();
		boolean[][][][] visited = new boolean[N][M][N][M];

		q.offer(new int[]{r1, c1, r2, c2, 0});
		visited[r1][c1][r2][c2] = true;

		while(!q.isEmpty()){
			int[] cur = q.poll();
			if(cur[4] >= 10){
				continue;
			}

			for(int d = 0; d < 4; d++){
				int nr1 = cur[0] + dx[d], nc1 = cur[1] + dy[d];
				int nr2 = cur[2] + dx[d], nc2 = cur[3] + dy[d];

				boolean out1 = nr1 < 0 || nr1 >= N || nc1 < 0 || nc1 >= M;
				boolean out2 = nr2 < 0 || nr2 >= N || nc2 < 0 || nc2 >= M;

				if(out1 && out2){
					continue;
				}
				if(out1 || out2){
					return cur[4] + 1;
				}

				if(grid[nr1][nc1] == '#'){
					nr1 = cur[0];
					nc1 = cur[1];
				}
				if(grid[nr2][nc2] == '#'){
					nr2 = cur[2];
					nc2 = cur[3];
				}

				if(!visited[nr1][nc1][nr2][nc2]){
					visited[nr1][nc1][nr2][nc2] = true;
					q.offer(new int[]{nr1, nc1, nr2, nc2, cur[4] + 1});
				}
			}
		}

		return -1;
	}
}