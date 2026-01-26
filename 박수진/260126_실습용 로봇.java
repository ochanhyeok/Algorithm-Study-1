public class Solution {
    public int[] solution(String command) {
        // 0: 북(+y), 1: 동(+x), 2: 남(-y), 3: 서(-x)
        int dir = 0;
        int x = 0, y = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);

            if (c == 'R') {
                dir = (dir + 1) % 4;
            } else if (c == 'L') {
                dir = (dir + 3) % 4;
            } else if (c == 'G') {
                x += dx[dir];
                y += dy[dir];
            } else if (c == 'B') {
                // 후진 = 현재 방향의 반대( +2 )
                int back = (dir + 2) % 4;
                x += dx[back];
                y += dy[back];
            }
        }

        return new int[]{x, y};
    }
}
 {
  
}
