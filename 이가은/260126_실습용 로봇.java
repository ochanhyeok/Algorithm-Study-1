class Solution {
    public int[] solution(String command) {
        int y = 0;
        int x = 0;
        int direction = 1; // 1: 북, 2: 동, 3: 남, 4: 서
        int[][] move = {{}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for (char cmd: command.toCharArray()) {
            if (cmd == 'R') {
                direction = rotate('R', direction);
            } else if (cmd == 'L') {
                direction = rotate('L', direction);
            } else if (cmd == 'G') {
                y += move[direction][0];
                x += move[direction][1];
            } else if (cmd == 'B') {
                y -= move[direction][0];
                x -= move[direction][1];
            }
        }
        
        return new int[] {x, y};
    }
    
    static int rotate(char dir, int currentDir) {
        int n = dir == 'R' ? 1 : -1;
        int res = currentDir + n;
        if (res % 4 == 0) return 4;  
        return (res + 4) % 4;
    }
    
}