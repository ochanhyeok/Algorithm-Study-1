import java.util.*;

class Solution {

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int[][] map = buildMap(rectangle);

		return bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
	}

	static int[][] buildMap(int[][] rectangle){
		int[][] map = new int[101][101];

		for(int[] r : rectangle){
			int x1 = r[0] * 2;
			int y1 = r[1] * 2;
			int x2 = r[2] * 2;
			int y2 = r[3] * 2;

			for(int x = x1; x <= x2; x++){
				map[x][y1] = 1;
				map[x][y2] = 1;
			}

			for(int y = y1; y <= y2; y++){
				map[x1][y] = 1;
				map[x2][y] = 1;
			}
		}

		for(int[] r : rectangle){
			int x1 = r[0] * 2;
			int y1 = r[1] * 2;
			int x2 = r[2] * 2;
			int y2 = r[3] * 2;
			for(int x = x1 + 1; x < x2; x++){
				for(int y = y1 + 1; y < y2; y++){
					map[x][y] = 0;
				}
			}
		}

		return map;
	}

	static int bfs(int[][] map, int sx, int sy, int ex, int ey){
		boolean[][] visited = new boolean[101][101];
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{sx, sy, 0});
		visited[sx][sy] = true;

		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int dist = cur[2];

			if(x == ex && y == ey){
				return dist / 2;
			}

			for(int d = 0; d < 4; d++){
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx < 0 || nx > 100 || ny < 0 || ny > 100){
					continue;
				}

				if(map[nx][ny] == 1 && !visited[nx][ny]){
					visited[nx][ny] = true;
					queue.offer(new int[]{nx, ny, dist + 1});
				}
			}
		}

		return -1;
	}
}