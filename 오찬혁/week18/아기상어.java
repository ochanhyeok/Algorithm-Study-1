import java.io.*;
import java.util.*;

public class Main{

	static int N;
	static int[][] grid;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];

		int sharkX = 0, sharkY = 0;
		int sharkSize = 2;
		int eatCnt = 0;
		int time = 0;

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j] == 9){
					sharkX = i;
					sharkY = j;
					grid[i][j] = 0; // 상어 칸은 빈칸처리
				}
			}
		}

		while(true){
			int[] result = bfs(sharkX, sharkY, sharkSize);

			if(result == null) break;

			int targetX = result[0];
			int targetY = result[1];
			int dist = result[2];

			time += dist;

			grid[sharkX][sharkY] = 0;
			sharkX = targetX;
			sharkY = targetY;
			eatCnt++;

			if(eatCnt == sharkSize){
				sharkSize++;
				eatCnt = 0;
			}
		}

		System.out.println(time);

	}

	static int[] bfs(int sharkX, int sharkY, int sharkSize){
		int[][] dist = new int[N][N];
		for(int[] row : dist){
			Arrays.fill(row, -1);
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{sharkX, sharkY});
		dist[sharkX][sharkY] = 0;

		List<int[]> cand = new ArrayList<>();
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int x = cur[0], y = cur[1];

			for(int d = 0; d < 4; d++){
				int nx = x + dx[d];
				int ny = y + dy[d];

				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(dist[nx][ny] != -1) continue;

				if(grid[nx][ny] > sharkSize) continue;

				dist[nx][ny] = dist[x][y] + 1;
				q.add(new int[]{nx, ny});

				if(grid[nx][ny] > 0 && grid[nx][ny] < sharkSize){
					cand.add(new int[]{nx, ny, dist[nx][ny]});
				}
			}
		}

		if(cand.isEmpty()) return null;

		cand.sort((a, b) -> {
			if(a[2] != b[2]) return a[2] - b[2];
			if(a[0] != b[0]) return a[0] - b[0];
			return a[1] - b[1];
		});

		return cand.get(0);
	}
}