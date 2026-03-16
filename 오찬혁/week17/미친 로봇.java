import java.io.*;
import java.util.*;

public class Main{

	static int N;
	static double answer;
	static double prob[] = new double[4];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited = new boolean[29][29];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		for(int i = 0; i < 4; i++){
			prob[i] = Integer.parseInt(st.nextToken()) / 100.0;
		}

		visited[14][14] = true;
		dfs(14, 14, 0, 1.0);

		System.out.println(answer);
	}

	static void dfs(int x, int y, int step, double curProb){
		if(step == N){
			answer += curProb;
			return;
		}

		for(int d = 0; d < 4; d++){
			int nx = x + dx[d];
			int ny = y + dy[d];

			if(nx < 0 || nx >= 29 || ny < 0 || ny >= 29){
				continue;
			}

			if(!visited[nx][ny] && prob[d] > 0){
				visited[nx][ny] = true;
				dfs(nx, ny, step + 1, curProb * prob[d]);
				visited[nx][ny] = false;
			}
		}
	}
}