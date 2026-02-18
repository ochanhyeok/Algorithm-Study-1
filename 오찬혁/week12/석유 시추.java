import java.util.*;

class Solution {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n, m;

	public int solution(int[][] land) {
		int answer = 0;
		n = land.length;
		m = land[0].length;
		int[][] label = new int[n][m];
		Map<Integer, Integer> sizeMap = new HashMap<>();
		int id = 1;

		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(land[i][j] == 1 && label[i][j] == 0){
					bfs(land, label, i, j, id, sizeMap);
					id++;
				}
			}
		}

		for(int col = 0; col < m; col++){
			Set<Integer> set = new HashSet<>();
			int total = 0;

			for(int row = 0; row < n; row++){
				int lb = label[row][col];
				if(lb != 0 && set.add(lb)){
					total += sizeMap.get(lb);
				}
			}
			answer = Math.max(answer, total);
		}

		return answer;
	}

	static void bfs(int[][] land, int[][] label, int si, int sj, int id, Map<Integer, Integer> sizeMap){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{si, sj});
		label[si][sj] = id;
		int size = 0;

		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			size++;
			for(int d = 0; d < 4; d++){
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(nx < 0 || nx >= n || ny < 0 || ny >= m){
					continue;
				}
				if(land[nx][ny] == 0 || label[nx][ny] != 0){
					continue;
				}
				label[nx][ny] = id;
				queue.offer(new int[]{nx, ny});
			}
		}
		sizeMap.put(id, size);
	}
}