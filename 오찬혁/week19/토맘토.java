import java.io.*;
import java.util.*;

public class Main{

	static int M, N, H;
	static int[][][] grid;
	static int[] dh = {0, 0, 0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		grid = new int[H][N][M];

		for(int h = 0; h < H; h++){
			for(int i = 0; i < N; i++){
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++){
					grid[h][i][j] = Integer.parseInt(st.nextToken());;
					if(grid[h][i][j] == 1){
						q.add(new int[]{h, i, j});
					}
				}
			}
		}

		int answer = bfs();
		System.out.println(answer);
	}

	static int bfs(){
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int h = cur[0], x = cur[1], y = cur[2];

			for(int d = 0; d < 6; d++){
				int nh = h + dh[d];
				int nx = x + dx[d];
				int ny = y + dy[d];

				if(nh < 0 || nh >= H || nx < 0 || nx >= N || ny < 0 || ny >= M){
					continue;
				}
				if(grid[nh][nx][ny] == -1 || grid[nh][nx][ny] == 1){
					continue;
				}

				if(grid[nh][nx][ny] == 0){
					grid[nh][nx][ny] = grid[h][x][y] + 1;
					q.add(new int[]{nh, nx, ny});
				}
			}
		}

		int answer = 0;
		for(int h = 0; h < H; h++){
			for(int i = 0; i < N; i++){
				for(int j = 0; j < M; j++){
					if(grid[h][i][j] == 0){
						return -1;
					}
					answer = Math.max(answer, grid[h][i][j]);
				}
			}
		}

		return answer - 1;
	}
}