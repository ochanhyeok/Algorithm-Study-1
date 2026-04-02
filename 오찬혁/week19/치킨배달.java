import java.io.*;
import java.util.*;

public class Main{

	static int N, M, answer = Integer.MAX_VALUE;
	static int[][] grid;
	static List<int[]> homes = new ArrayList<>();
	static List<int[]> chick = new ArrayList<>();
	static int[][] selected = new int[13][2];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][N];

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j] == 1){
					homes.add(new int[]{i, j});
				} else if(grid[i][j] == 2){
					chick.add(new int[]{i, j});
				}
			}
		}

		dfs(0, 0);

		System.out.println(answer);
	}

	static void dfs(int start, int cnt){
		if(cnt == M){
			int total = 0;
			for(int[] home : homes){
				int minDist = Integer.MAX_VALUE;
				for(int i = 0; i < M; i++){
					int dist = Math.abs(home[0] - selected[i][0])
						+ Math.abs(home[1] - selected[i][1]);
					minDist = Math.min(minDist, dist);
				}
				total += minDist;
			}
			answer = Math.min(total, answer);
			return;
		}

		for(int i = start; i < chick.size(); i++){
			selected[cnt] = chick.get(i);
			dfs(i + 1, cnt + 1);
		}
	}
}