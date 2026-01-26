import java.util.*;
class Solution {
    public int[] solution(String command) {
        int[] answer = new int[2];

        List<int[]> list = new ArrayList();
        list.add(new {0,1});    //상
        list.add(new {1,0});    //우
        list.add(new {0,-1});    //하
        list.add(new {-1,0});    //좌

        int dir = 0;
        int row = 0; col = 0;
        for(int i=0; i<command.length(); i++){
            char currCommand = command.charAt(i);
            if (currCommand == 'R'){
                d = (d+1)%4;
            } else if (currCommand == 'L'){
                d = (d-1)%4;
                if (d < 0) d = 3;
            } else if (currCommand == 'G'){
                row += list.get(d)[0];
                col += list.get(d)[1];
            } else if (currCommand == 'B'){
                row -= list.get(d)[0];
                col -= list.get(d)[1];
            }
        }
        answer[0] = row; answer[1] = col;
        return answer;
    }
}