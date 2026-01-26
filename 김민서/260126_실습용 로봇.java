class Solution {
    public int[] solution(String command) {
        int[] answer = {0, 0};
        int[] direction = {0, 1};
        
        char[] com = command.toCharArray();
        
        for(char c : com) {
            if (c == 'R') {
                if (direction[0] == 0 && direction[1] == 1) {
                    direction[0] = 1;
                    direction[1] = 0;
                } else if (direction[0] == 1 && direction[1] == 0) {
                    direction[0] = 0;
                    direction[1] = -1;
                } else if (direction[0] == 0 && direction[1] == -1) {
                    direction[0] = -1;
                    direction[1] = 0;
                } else if (direction[0] == -1 && direction[1] == 0) {
                    direction[0] = 0;
                    direction[1] = 1;
                }
            } else if (c == 'L') {
                if (direction[0] == 0 && direction[1] == 1) {
                    direction[0] = -1;
                    direction[1] = 0;
                } else if (direction[0] == -1 && direction[1] == 0) {
                    direction[0] = 0;
                    direction[1] = -1;
                } else if (direction[0] == 0 && direction[1] == -1) {
                    direction[0] = 1;
                    direction[1] = 0;
                } else if (direction[0] == 1 && direction[1] == 0) {
                    direction[0] = 0;
                    direction[1] = 1;
                }
            } else if (c == 'G') {
                answer[0] += direction[0];
                answer[1] += direction[1];
            } else if (c == 'B') {
                answer[0] -= direction[0];
                answer[1] -= direction[1];
            }
        }
        
        return answer;
    }
}