import java.io.*;
import java.util.*;

public class Main{

	static int N, answer = 1;
	static int[][] grid;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int h = 1; h < 100; h++){
			visited = new boolean[N][N];
			int cnt = 0;

			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					if(!visited[i][j] && grid[i][j] > h){
						dfs(i, j, h);
						cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);
		}

		System.out.println(answer);
	}

	static void dfs(int i, int j, int h){
		visited[i][j] = true;
		for(int d = 0; d < 4; d++){
			int nx = i + dx[d];
			int ny = j + dy[d];

			if(nx < 0 || ny < 0 || nx >= N || ny >= N){
				continue;
			}

			if(!visited[nx][ny] && grid[nx][ny] > h){
				dfs(nx, ny, h);
			}
		}
	}
}