class Solution {
	public int[] solution(String command) {
		String[] cmd = command.split("");

		int[] now = {0, 0};
		int dir = 0;

		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};

		for(int i = 0; i < cmd.length; i++){
			if("G".equals(cmd[i])){ // go
				now[0] += dx[dir];
				now[1] += dy[dir];
			} else if("B".equals(cmd[i])){ // back
				now[0] -= dx[dir];
				now[1] -= dy[dir];
			} else if("R".equals(cmd[i])){ // right
				dir = (dir + 1) % 4;
			} else { // left
				dir = (dir + 3) % 4;
			}
		}

		return now;
	}
}