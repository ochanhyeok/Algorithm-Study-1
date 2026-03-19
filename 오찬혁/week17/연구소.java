import java.io.*;
import java.util.*;

public class Main{

	static int N, M;
	static int answer = 0;
	static int[][] grid;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		grid = new int[N][M];
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		placeWall(0);

		System.out.println(answer);
	}

	static void placeWall(int cnt){
		if(cnt == 3){
			answer = Math.max(answer, bfs());
			return;
		}

		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				if(grid[i][j] == 0){
					grid[i][j] = 1;
					placeWall(cnt + 1);
					grid[i][j] = 0;
				}
			}
		}
	}

	static int bfs(){
		Queue<int[]> q = new LinkedList<>();
		int[][] temp = new int[N][M];

		for(int i = 0; i < N; i++){
			temp[i] = grid[i].clone();
			for(int j = 0; j < M; j++){
				if(grid[i][j] == 2){
					q.offer(new int[]{i, j});
				}
			}
		}

		while(!q.isEmpty()){
			int[] cur = q.poll();
			for(int d = 0; d < 4; d++){
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if(nx < 0 || nx >= N || ny < 0 || ny >= M){
					continue;
				}

				if(temp[nx][ny] == 0){
					temp[nx][ny] = 2;
					q.offer(new int[]{nx, ny});
				}
			}
		}

		int safe = 0;
		for(int[] row : temp){
			for(int v : row){
				if(v == 0){
					safe++;
				}
			}
		}

		return safe;
	}
}